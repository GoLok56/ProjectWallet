package io.github.golok56.domain.usecases

import io.github.golok56.domain.commons.Transformer
import io.github.golok56.domain.entities.TransactionEntity
import io.github.golok56.domain.repositories.Repository
import io.reactivex.Single

class RemoveTransaction(
        transformer: Transformer<Int>,
        private val transactionRepository: Repository<TransactionEntity>
) : UseCase<Int>(transformer) {
    private var transaction: TransactionEntity? = null

    fun remove(transaction: TransactionEntity): Single<Int> {
        this.transaction = transaction
        return observable(null)
    }

    override fun createObservable(item: Int?): Single<Int> =
            Single.fromCallable { transactionRepository.remove(transaction!!) }
}