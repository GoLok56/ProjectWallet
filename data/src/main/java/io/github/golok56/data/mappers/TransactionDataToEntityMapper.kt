package io.github.golok56.data.mappers

import io.github.golok56.data.entities.TransactionData
import io.github.golok56.domain.entities.TransactionEntity
import io.github.golok56.domain.entities.TransactionType
import io.github.golok56.domain.mappers.Mapper
import javax.inject.Inject

class TransactionDataToEntityMapper @Inject constructor()
    : Mapper<TransactionData, TransactionEntity>() {
    override fun mapFrom(from: TransactionData): TransactionEntity =
            TransactionEntity(
                    from.id,
                    from.amount,
                    from.moneyLeft,
                    from.date,
                    from.description,
                    TransactionType.valueOf(from.type),
                    from.categoryId
            )
}