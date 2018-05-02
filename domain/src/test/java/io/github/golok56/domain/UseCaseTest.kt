package io.github.golok56.domain

import io.github.golok56.domain.commons.Transformer
import io.github.golok56.domain.entities.CategoryEntity
import io.github.golok56.domain.repositories.Repository
import io.github.golok56.domain.usecases.GetAllCategories
import io.github.golok56.domain.usecases.RemoveCategory
import io.reactivex.Single
import io.reactivex.Single.just
import io.reactivex.SingleSource
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UseCaseTest {

    private fun getCategory(id: Int): CategoryEntity = CategoryEntity(id, "Category$id")
    private fun generateCategories(): List<CategoryEntity> = (0..4).map { getCategory(it) }

    @Test
    fun getAllCategory() {
        val categoryRepository = mock(Repository::class.java) as Repository<CategoryEntity>
        `when`(categoryRepository.getAll()).thenReturn(just(generateCategories()))

        val categories = GetAllCategories(TestTranformer(), categoryRepository)
        categories.getAll().test()
                .assertValue { it.size == 5 }
                .assertComplete()
    }

    @Test
    fun removeCategory() {
        val categoryRepository = mock(Repository::class.java) as Repository<CategoryEntity>
        val category = getCategory(3)
        `when`(categoryRepository.remove(category)).thenReturn(category.id)

        RemoveCategory(TestTranformer(), categoryRepository).remove(category).test()
                .assertValue { category.id == it }
                .assertComplete()
    }

    private class TestTranformer<T> : Transformer<T>() {
        override fun apply(upstream: Single<T>): SingleSource<T> = upstream
    }
}