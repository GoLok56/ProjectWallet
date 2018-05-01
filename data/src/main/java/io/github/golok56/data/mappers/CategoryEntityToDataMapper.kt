package io.github.golok56.data.mappers

import io.github.golok56.data.entities.CategoryData
import io.github.golok56.domain.entities.CategoryEntity
import io.github.golok56.domain.mappers.Mapper
import javax.inject.Inject

class CategoryEntityToDataMapper @Inject constructor() : Mapper<CategoryEntity, CategoryData>() {
    override fun mapFrom(from: CategoryEntity): CategoryData = CategoryData(from.id, from.name)
}