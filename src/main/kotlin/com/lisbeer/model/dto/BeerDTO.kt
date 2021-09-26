package com.lisbeer.model.dto

import com.lisbeer.model.Beer

data class BeerDTO(
    val name: String,
    val evaluation: Double = 0.0,
    val price: Double,
    val photoUrl: String,
) {
    fun toBeer(): Beer = Beer(null, name, evaluation, price, photoUrl)
}