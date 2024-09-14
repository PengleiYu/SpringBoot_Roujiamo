package com.utopia.roujiamo.repository

import com.utopia.roujiamo.bean.Ingredient
import org.springframework.data.repository.CrudRepository


interface IngredientRepository : CrudRepository<Ingredient, String>