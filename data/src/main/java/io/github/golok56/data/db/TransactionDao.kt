package io.github.golok56.data.db

import android.arch.persistence.room.*
import io.github.golok56.data.entities.TransactionData
import io.reactivex.Single

@Dao
interface TransactionDao {
    @Query("SELECT * FROM transactions")
    fun getAll(): Single<List<TransactionData>>

    @Insert
    fun insert(transaction: TransactionData): Long

    @Delete
    fun delete(transaction: TransactionData): Int

    @Update
    fun update(transaction: TransactionData): Int
}