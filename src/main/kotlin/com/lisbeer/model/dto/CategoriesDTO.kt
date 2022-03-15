package com.lisbeer.model.dto

import com.lisbeer.domain.categories.Categories

data class CategoriesDTO(
    val name: String,
    val evaluation: Double = 0.0
) {
    fun toCategorie(): Categories = Categories(0L, name, evaluation)
}