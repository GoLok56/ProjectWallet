package io.github.golok56.domain.usecases

import io.github.golok56.domain.commons.Transformer
import io.reactivex.Single

abstract class UseCase<T>(private val transformer: Transformer<T>) {
    abstract fun createObservable(item: T?): Single<T>

    fun observable(item: T?): Single<T> = createObservable(item).compose(transformer)
}