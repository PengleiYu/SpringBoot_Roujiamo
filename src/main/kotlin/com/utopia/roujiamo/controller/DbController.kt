package com.utopia.roujiamo.controller

import com.utopia.roujiamo.bean.Ingredient
import com.utopia.roujiamo.repository.IngredientRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.sql.DataSource

@Controller
@RequestMapping("/database")
class DbController(
    private val dataSource: DataSource,
    private val ingredientRepo: IngredientRepository
) {
    @GetMapping("/url")
    @ResponseBody
    fun getDbUrl(): String = dataSource.connection.metaData.url

    @GetMapping("/ingredient")
    fun getIngredientList(): String {
        return "ingredient"
    }

    @ModelAttribute("ingredientMap")
    fun getIngredientMode(): Map<String, List<Ingredient>> {
        return ingredientRepo.findAll()
            .groupBy(Ingredient::type)
            .toList()
            .associate { (it.first?.name?.uppercase() ?: "") to it.second }
    }
}