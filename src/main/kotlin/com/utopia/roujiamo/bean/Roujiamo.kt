package com.utopia.roujiamo.bean

data class Roujiamo(
    var id: Long? = null,
    var name: String? = null,
    var ingredients: MutableList<Ingredient>? = mutableListOf(),
)