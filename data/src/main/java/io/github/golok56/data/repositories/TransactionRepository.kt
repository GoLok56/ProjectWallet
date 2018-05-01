package io.github.golok56.data.repositories

import io.github.golok56.data.db.AppDatabase
import io.github.golok56.data.entities.TransactionData
import io.github.golok56.domain.entities.TransactionEntity
import io.github.golok56.domain.mappers.Mapper
import io.github.golok56.domain.repositories.Cache
import io.github.golok56.domain.repositories.Repository
import io.reactivex.Single

class TransactionRepository(
        database: AppDatabase,
        private val cache: Cache<TransactionEntity>,
        private val dataToEntityMapper: Mapper<TransactionData, TransactionEntity>,
        private val entityToDataMapper: Mapper<TransactionEntity, TransactionData>
) : Repository<TransactionEntity> {
    private val transactionDao = database.getTransactionDao()

    override fun getAll(): Single<List<TransactionEntity>> {
        return if(cache.isEmpty()) {
            transactionDao.getAll()
                    .map { results -> results.map { dataToEntityMapper.mapFrom(it) } }
                    .doOnSuccess { cache.addAll(it) }
        } else {
            cache.getAll()
        }
    }

    override fun edit(item: TransactionEntity): Int {
        cache.edit(item)
        return transactionDao.update(entityToDataMapper.mapFrom(item))
    }

    override fun save(item: TransactionEntity): Int {
        cache.add(item)
        return transactionDao.insert(entityToDataMapper.mapFrom(item)).toInt()
    }

    override fun remove(item: TransactionEntity): Int {
        cache.remove(item)
        return transactionDao.delete(entityToDataMapper.mapFrom(item))
    }
}