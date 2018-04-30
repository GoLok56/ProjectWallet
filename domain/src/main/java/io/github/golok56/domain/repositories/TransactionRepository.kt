package io.github.golok56.domain.repositories

import io.github.golok56.domain.entities.TransactionEntity
import io.reactivex.Single

interface TransactionRepository {
    fun getTransactions(): Single<List<TransactionEntity>>
    fun deleteTransaction()
    fun editTransaction(): Single<TransactionEntity>
    fun saveTransaction(): Single<TransactionEntity>
}