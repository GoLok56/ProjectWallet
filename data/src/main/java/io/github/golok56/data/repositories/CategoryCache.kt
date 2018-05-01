package io.github.golok56.data.repositories

import io.github.golok56.domain.entities.CategoryEntity
import io.github.golok56.domain.repositories.Cache
import io.reactivex.Single

class CategoryCache : Cache<CategoryEntity> {
    private var categories: ArrayList<CategoryEntity> = ArrayList()

    override fun isEmpty(): Boolean = categories.isEmpty()

    override fun addAll(items: List<CategoryEntity>) {
        categories = items as ArrayList<CategoryEntity>
    }

    override fun add(item: CategoryEntity) {
        categories.add(item)
    }

    override fun remove(item: CategoryEntity) {
        categories.remove(item)
    }

    override fun edit(item: CategoryEntity) {
        categories = categories.map {
            if (it.id == item.id) item
            else it
        } as ArrayList<CategoryEntity>
    }

    override fun getAll(): Single<List<CategoryEntity>> = Single.just(categories)
}