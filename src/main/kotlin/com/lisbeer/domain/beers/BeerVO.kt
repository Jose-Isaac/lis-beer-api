package com.lisbeer.domain.beers

import com.lisbeer.domain.categories.CategoryVO
import java.math.BigDecimal
import java.util.*


data class BeerVO(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val evaluation: Double = 0.0,
    val brand: String,
    val price: BigDecimal,
    val photoUrl: String,
    val categories: List<CategoryVO> = listOf(),
    val storeId: UUID
)
