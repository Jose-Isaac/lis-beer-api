package com.lisbeer.domain.beers

import com.lisbeer.domain.categories.CategoryVO
import com.lisbeer.domain.stores.StoreVO
import com.lisbeer.resource.beer.representation.BeerDetailsResponseRepresentation

fun BeerVO.toEntity() = Beer(
    id = id,
    name = name,
    evaluation = evaluation,
    brand = brand,
    price = price,
    photoUrl = photoUrl,
    storeId = storeId
)

fun Beer.toVO(categories: List<CategoryVO>) = BeerVO(
    id = id,
    name = name,
    evaluation = evaluation,
    brand = brand,
    price = price,
    photoUrl = photoUrl,
    categories = categories,
    storeId = storeId
)

fun Beer.toVO() = BeerVO(
    id = id,
    name = name,
    evaluation = evaluation,
    brand = brand,
    price = price,
    photoUrl = photoUrl,
    storeId = storeId
)

fun BeerVO.toDetailsResponse(storeVO: StoreVO) = BeerDetailsResponseRepresentation(
    name = this.name,
    brand = this.brand,
    price = this.price.toString(),
    photoUrl = this.photoUrl,
    categories = this.categories,
    store = storeVO
)