package io.github.golok56.domain.entities

data class TransactionEntity (
        var id: Int = 0,
        var amount: Int,
        var moneyLeft: Int,
        var date: String,
        var description: String,
        var type: TransactionType,
        var categoryId: Int
)

enum class TransactionType { EXPENSE, INCOME }