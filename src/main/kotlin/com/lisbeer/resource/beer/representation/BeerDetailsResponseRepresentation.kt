package com.lisbeer.resource.beer.representation

import com.lisbeer.domain.categories.CategoryVO
import com.lisbeer.domain.stores.StoreVO

data class BeerDetailsResponseRepresentation(
    val name: String,
    val brand: String,
    val price: String,
    val photoUrl: String,
    val categories: List<CategoryVO>,
    val store: StoreVO
)
