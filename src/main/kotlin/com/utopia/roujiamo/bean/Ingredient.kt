package com.utopia.roujiamo.bean

import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
data class Ingredient(
    @field:Id
    val id: String? = null,
    val name: String? = null,
    val type: IngredientType? = null,
)