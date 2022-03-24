package com.lisbeer.domain.stores

import com.lisbeer.application.rules.Access
import com.lisbeer.domain.address.AddressVO
import java.util.*

data class StoreVO(
    val id: UUID = UUID.randomUUID(),
    val fantasyName: String,
    val accessRule: Access = Access.STORE,
    val email: String,
    val password: String,
    val evaluation: Double = 0.0,
    val photoUrl: String,
    val address: AddressVO
)
