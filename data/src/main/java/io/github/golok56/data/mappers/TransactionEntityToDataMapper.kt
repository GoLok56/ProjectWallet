package io.github.golok56.data.mappers

import io.github.golok56.data.entities.TransactionData
import io.github.golok56.domain.entities.TransactionEntity
import io.github.golok56.domain.mappers.Mapper
import javax.inject.Inject

class TransactionEntityToDataMapper @Inject constructor()
    : Mapper<TransactionEntity, TransactionData>() {
    override fun mapFrom(from: TransactionEntity): TransactionData =
            TransactionData(
                    from.id,
                    from.amount,
                    from.moneyLeft,
                    from.date,
                    from.description,
                    from.type.type,
                    from.categoryId
            )
}