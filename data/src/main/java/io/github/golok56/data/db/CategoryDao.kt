package io.github.golok56.data.db

import android.arch.persistence.room.*
import io.github.golok56.data.entities.CategoryData
import io.reactivex.Single

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories")
    fun getAll(): Single<List<CategoryData>>

    @Insert
    fun insert(category: CategoryData): Int

    @Delete
    fun delete(category: CategoryData): Int

    @Update
    fun update(category: CategoryData): Int
}