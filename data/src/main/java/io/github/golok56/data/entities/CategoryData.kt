package io.github.golok56.data.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "categories")
class CategoryData (
        @PrimaryKey var id: Int = -1,
        var name: String
)