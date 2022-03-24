package com.lisbeer.domain.beers

import java.util.Optional

interface BeerService {
    fun findAll(orderBy: String, evaluation: Boolean): List<BeerVO>
    fun findById(id: Long): Optional<BeerVO>
    fun create(beer: BeerVO, categoriesId: List<String>): BeerVO
}