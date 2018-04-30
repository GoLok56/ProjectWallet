package io.github.golok56.domain.usecases

import io.github.golok56.domain.commons.Transformer
import io.github.golok56.domain.entities.TransactionEntity
import io.github.golok56.domain.repositories.Repository
import io.reactivex.Single

class GetAllTransactions(
        transformer: Transformer<List<TransactionEntity>>,
        private val transactionRepository: Repository<TransactionEntity>
) : UseCase<List<TransactionEntity>>(transformer) {
    fun getAll(): Single<List<TransactionEntity>> = observable(null)

    override fun createObservable(item: List<TransactionEntity>?): Single<List<TransactionEntity>> =
            transactionRepository.getAll()
}