package io.github.golok56.data.mappers

import io.github.golok56.data.entities.CategoryData
import io.github.golok56.domain.entities.CategoryEntity
import io.github.golok56.domain.mappers.Mapper
import javax.inject.Inject

class CategoryDataToEntityMapper @Inject constructor() : Mapper<CategoryData, CategoryEntity>() {
    override fun mapFrom(from: CategoryData): CategoryEntity = CategoryEntity(from.id, from.name)
}