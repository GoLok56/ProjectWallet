package io.github.golok56.data.repositories

import io.github.golok56.data.db.AppDatabase
import io.github.golok56.data.entities.CategoryData
import io.github.golok56.domain.entities.CategoryEntity
import io.github.golok56.domain.mappers.Mapper
import io.github.golok56.domain.repositories.Cache
import io.github.golok56.domain.repositories.Repository
import io.reactivex.Single

class CategoryRepository(
        database: AppDatabase,
        private val cache: Cache<CategoryEntity>,
        private val dataToEntityMapper: Mapper<CategoryData, CategoryEntity>,
        private val entityToDataMapper: Mapper<CategoryEntity, CategoryData>
) : Repository<CategoryEntity> {
    private val categoryDao = database.getCategoryDao()

    override fun getAll(): Single<List<CategoryEntity>> {
        return if (cache.isEmpty()) {
            categoryDao.getAll()
                    .map { results -> results.map { dataToEntityMapper.mapFrom(it) } }
                    .doOnSuccess { cache.addAll(it) }
        } else {
            cache.getAll()
        }
    }

    override fun edit(item: CategoryEntity): Int {
        cache.edit(item)
        return categoryDao.update(entityToDataMapper.mapFrom(item))
    }

    override fun save(item: CategoryEntity): Int {
        cache.add(item)
        return categoryDao.insert(entityToDataMapper.mapFrom(item)).toInt()
    }

    override fun remove(item: CategoryEntity): Int {
        cache.remove(item)
        return categoryDao.delete(entityToDataMapper.mapFrom(item))
    }
}