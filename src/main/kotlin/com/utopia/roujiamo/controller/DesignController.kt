package com.utopia.roujiamo.controller

import com.utopia.roujiamo.bean.Ingredient
import com.utopia.roujiamo.bean.Roujiamo
import com.utopia.roujiamo.repository.IngredientRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

private val log = LoggerFactory.getLogger(DesignController::class.java)

@Controller
@RequestMapping("/design")
class DesignController(
    private val ingredientRepo: IngredientRepository,
) {

    @GetMapping
    fun showDesignForm(): String = "design"

    @PostMapping
    fun processRoujiamo(roujiamo: Roujiamo): String {
        log.info("obj=${roujiamo}")
        return "design"
    }

    @ModelAttribute("roujiamo")
    fun createRoujiamo(): Roujiamo {
        log.info("createRoujiamo() called")
        return Roujiamo()
    }

    @ModelAttribute("ingredientMap")
    fun getIngredientMode(): Map<String, List<Ingredient>> {
        return ingredientRepo.findAll()
            .groupBy(Ingredient::type)
            .toList()
            .associate { (it.first?.name?.uppercase() ?: "") to it.second }
    }
}