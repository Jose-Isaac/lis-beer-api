package com.lisbeer.model.dto

import com.lisbeer.model.Categories

class CategoriesDTO(
    val name: String,
    val evaluation: Int = 0
) {
    fun toCategorie(): Categories = Categories(null, name, evaluation)
}