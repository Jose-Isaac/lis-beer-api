package com.lisbeer.resource.beer.representation

import com.lisbeer.domain.beers.BeerVO
import java.math.BigDecimal
import java.util.*


data class beerRepresentation(
    val name: String,
    val brand: String,
    val price: String,
    val photoUrl: String,
    val categories: List<String>,
    val storeId: String
) {
    fun toVO() = BeerVO(
        name = this.name,
        brand = this.brand,
        price = BigDecimal(this.price),
        photoUrl = this.photoUrl,
        storeId = UUID.fromString(this.storeId)
    )
}
