package com.lisbeer.domain.address

import java.util.UUID

data class AddressVO(
    val id: UUID = UUID.randomUUID(),
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val houseNumber: Int,
    val complement: String? = null
)
