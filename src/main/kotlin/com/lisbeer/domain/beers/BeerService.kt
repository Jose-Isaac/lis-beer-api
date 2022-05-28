package com.lisbeer.domain.beers

import com.lisbeer.resource.beer.representation.BeerDetailsResponseRepresentation
import java.util.*

interface BeerService {
    fun findAll(orderBy: String, evaluation: Boolean): List<BeerVO>
    fun findById(id: UUID) : Optional<BeerDetailsResponseRepresentation>
    fun create(beer: BeerVO, categoriesId: List<String>): BeerVO
    fun findAllByStoreId(storeId: UUID): List<BeerVO>
    fun findAllByCategoryId(categoryId: UUID): List<BeerVO>
}