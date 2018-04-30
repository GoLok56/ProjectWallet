package io.github.golok56.domain.repositories

import io.reactivex.Single

interface Repository<T> {
    fun getAll(): Single<List<T>>
    fun edit(item: T): Single<Boolean>
    fun save(item: T): Single<Boolean>
    fun remove(itemId: Int): Single<Boolean>
}