package com.lisbeer.resource.store.representation

import com.lisbeer.application.rules.Access
import com.lisbeer.domain.address.AddressVO
import com.lisbeer.domain.beers.BeerVO
import java.util.*

data class StoreDetailsResponseRepresentation(
    val id: UUID = UUID.randomUUID(),
    val fantasyName: String,
    val accessRule: Access = Access.STORE,
    val email: String,
    val password: String,
    val evaluation: Double = 0.0,
    val photoUrl: String,
    val address: AddressVO,
    val beers: List<BeerVO>
)