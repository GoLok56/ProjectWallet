package io.github.golok56.data

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import io.github.golok56.data.db.AppDatabase
import io.github.golok56.data.db.CategoryDao
import io.github.golok56.data.db.TransactionDao
import io.github.golok56.data.entities.CategoryData
import io.github.golok56.data.entities.TransactionData
import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {

    private lateinit var database: AppDatabase
    private lateinit var transactionDao: TransactionDao
    private lateinit var categoryDao: CategoryDao

    @Before
    fun before() {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase::class.java).build()
        transactionDao = database.getTransactionDao()
        categoryDao = database.getCategoryDao()
    }

    @After
    fun after() {
        database.close()
    }

    @Test
    fun testTransactionInsertion() {
        transactionDao.getAll()
                .test()
                .assertValue { it.isEmpty() }
                .assertComplete()

        categoryDao.getAll()
                .test()
                .assertValue { it.isEmpty() }
                .assertComplete()

        categoryDao.insert(CategoryData(1, "Makan"))

        categoryDao.getAll()
                .test()
                .assertValue { it.isNotEmpty() }
                .assertComplete()

        val transaction = TransactionData(1, 10000, 1000, Date().toString(),
                "Lalala", "Pengeluaran", 1)
        transactionDao.insert(transaction)

        transactionDao.getAll()
                .test()
                .assertValue { it.isNotEmpty() }
                .assertComplete()
    }

}