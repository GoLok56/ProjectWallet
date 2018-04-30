package io.github.golok56.domain.repositories

import io.reactivex.Single

interface Repository<T> {
    fun getAll(): Single<List<T>>
    fun edit(item: T): Int
    fun save(item: T): Int
    fun remove(itemId: Int): Int
}