package com.utopia.roujiamo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.sql.DataSource

@Controller
@RequestMapping("/database")
class DbController(private val dataSource: DataSource) {
    @GetMapping("/url")
    @ResponseBody
    fun getDbUrl(): String = dataSource.connection.metaData.url

    @GetMapping("/ingredient")
    fun getIngredientList(): String {
        return "ingredient"
    }

    @ModelAttribute("ingredient")
    fun getIngredientMode(): String {
        return "配料模型"
    }
}