package io.github.golok56.domain.usecases

import io.github.golok56.domain.commons.Transformer
import io.github.golok56.domain.entities.CategoryEntity
import io.github.golok56.domain.repositories.Repository
import io.reactivex.Single

class GetAllCategories(
        transformer: Transformer<List<CategoryEntity>>,
        private val categoryRepository: Repository<CategoryEntity>
) : UseCase<List<CategoryEntity>>(transformer) {
    fun getAll(): Single<List<CategoryEntity>> = observable(null)

    override fun createObservable(item: List<CategoryEntity>?): Single<List<CategoryEntity>> =
            categoryRepository.getAll()
}