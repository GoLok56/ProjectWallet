package io.github.golok56.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.github.golok56.data.entities.CategoryData
import io.github.golok56.data.entities.TransactionData

@Database(entities = [TransactionData::class, CategoryData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getTransactionDao(): TransactionDao
}