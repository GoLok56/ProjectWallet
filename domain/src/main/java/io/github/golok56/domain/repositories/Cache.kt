package io.github.golok56.domain.repositories

import io.reactivex.Single

interface Cache<T> {
    fun isEmpty(): Boolean
    fun add(item: T)
    fun remove(item: T)
    fun edit(item: T)
    fun getAll(): Single<List<T>>
}