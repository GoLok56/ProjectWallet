package io.github.golok56.domain.mappers

import io.reactivex.Observable

abstract class Mapper<in E, T> {
    abstract fun mapFrom(from: E): T

    fun observable(from: E): Observable<T> = Observable.fromCallable { mapFrom(from) }
    fun observable(from: List<E>): Observable<List<T>> =
            Observable.fromCallable { from.map { mapFrom(it) } }
}