package io.github.golok56.domain.repositories

import io.github.golok56.domain.entities.TransactionEntity
import io.reactivex.Single

interface TransactionRepository {
    fun getTransactions(): Single<List<TransactionEntity>>
    fun deleteTransaction(transactionId: Int): Single<Boolean>
    fun editTransaction(transaction: TransactionEntity): Single<TransactionEntity>
    fun saveTransaction(transaction: TransactionEntity): Single<TransactionEntity>
}