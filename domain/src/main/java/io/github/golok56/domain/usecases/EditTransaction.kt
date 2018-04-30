package io.github.golok56.domain.usecases

import io.github.golok56.domain.commons.Transformer
import io.github.golok56.domain.entities.TransactionEntity
import io.github.golok56.domain.repositories.Repository
import io.reactivex.Single

class EditTransaction(
        transformer: Transformer<Int>,
        private val transactionRepository: Repository<TransactionEntity>,
        private val transaction: TransactionEntity
) : UseCase<Int>(transformer) {
    fun edit(): Single<Int> = observable(null)

    override fun createObservable(item: Int?): Single<Int> =
            Single.fromCallable { transactionRepository.edit(transaction) }
}