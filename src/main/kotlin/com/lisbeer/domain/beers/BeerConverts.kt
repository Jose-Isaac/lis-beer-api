package com.lisbeer.domain.beers

import com.lisbeer.domain.categories.CategoryVO

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