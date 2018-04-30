package io.github.golok56.domain.mappers

import io.reactivex.Single

abstract class Mapper<in E, T> {
    abstract fun mapFrom(from: E): T

    fun observable(from: E): Single<T> = Single.fromCallable { mapFrom(from) }
    fun observable(from: List<E>): Single<List<T>> =
            Single.fromCallable { from.map { mapFrom(it) } }
}