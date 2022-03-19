package com.lisbeer.domain.stores

import com.lisbeer.application.rules.Access
import com.lisbeer.domain.address.Address
import com.lisbeer.domain.beers.Beer
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email

class StoreVO(
    val id: Long = 0L,
    val publicId: UUID = UUID.randomUUID(),
    val name: String,
    val accessRule: Access = Access.STORE,
    val email: String,
    val password: String,
    val evaluation: Double = 0.0,
    val photoUrl: String,
    val beers: List<Beer> = listOf(),
    val address: Address
)
