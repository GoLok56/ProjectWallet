package io.github.golok56.data.repositories

import io.github.golok56.domain.entities.TransactionEntity
import io.github.golok56.domain.repositories.Cache
import io.reactivex.Single
import java.util.ArrayList

class TransactionCache : Cache<TransactionEntity> {
    private var transactions: ArrayList<TransactionEntity> = ArrayList()

    override fun isEmpty(): Boolean = transactions.isEmpty()

    override fun addAll(items: List<TransactionEntity>) {
        transactions = items as ArrayList<TransactionEntity>
    }

    override fun add(item: TransactionEntity) {
        transactions.add(item)
    }

    override fun remove(item: TransactionEntity) {
        transactions.remove(item)
    }

    override fun edit(item: TransactionEntity) {
        transactions = transactions.map {
            if(it.id == item.id) item
            else it
        } as ArrayList<TransactionEntity>
    }

    override fun getAll(): Single<List<TransactionEntity>> = Single.just(transactions)
}