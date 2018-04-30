package io.github.golok56.domain.usecases

import io.github.golok56.domain.commons.Transformer
import io.github.golok56.domain.entities.CategoryEntity
import io.github.golok56.domain.repositories.Repository
import io.reactivex.Single

class AddCategory(
        transformer: Transformer<Int>,
        private val categoryRepository: Repository<CategoryEntity>
) : UseCase<Int>(transformer) {
    private var category: CategoryEntity? = null

    fun add(category: CategoryEntity): Single<Int> {
        this.category = category
        return observable(null)
    }

    override fun createObservable(item: Int?): Single<Int> =
            Single.fromCallable { categoryRepository.save(category!!) }
}