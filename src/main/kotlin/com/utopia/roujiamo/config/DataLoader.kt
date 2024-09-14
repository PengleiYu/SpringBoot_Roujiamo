package com.utopia.roujiamo.config

import com.utopia.roujiamo.bean.Ingredient
import com.utopia.roujiamo.bean.IngredientType
import com.utopia.roujiamo.repository.IngredientRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader(private val repo: IngredientRepository) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(DataLoader::class.java)

    override fun run(vararg args: String?) {
        logger.info("run: ${args.contentToString()}")
        val oldSize = repo.findAll().toList().size
        listOf(
            Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
            Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
            Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
            Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
            Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
            Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
            Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
            Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
            Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
            Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE),
        ).let(repo::saveAll)
        val newSize = repo.findAll().toList().size
        logger.info("加载数据: $oldSize -> $newSize")
    }
}