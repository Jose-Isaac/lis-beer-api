package com.lisbeer.domain.beers

import java.util.*

interface BeerService {
    fun findAll(orderBy: String, evaluation: Boolean): List<BeerVO>
    fun findById(id: Long): Optional<BeerVO>
    fun create(beer: BeerVO, categoriesId: List<String>): BeerVO
    fun findAllByStoreId(storeId: UUID): List<BeerVO>
}