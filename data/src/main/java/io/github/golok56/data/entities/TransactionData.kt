package io.github.golok56.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "transactions",
        indices = [Index("categoryId", name = "categoryIdForeignKeyTransaction")],
        foreignKeys = [ForeignKey(entity = CategoryData::class, parentColumns = ["id"],
                childColumns = ["categoryId"])])
class TransactionData(
        @PrimaryKey var id: Int = -1,
        var amount: Int,
        var moneyLeft: Int,
        var date: String,
        var description: String,
        var type: String,
        var categoryId: Int
)