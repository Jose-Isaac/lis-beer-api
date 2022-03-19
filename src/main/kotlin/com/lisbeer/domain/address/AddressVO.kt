package com.lisbeer.domain.address

data class AddressVO(
    val id: Long = 0L,
    val street: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val number: Int,
    val complement: String? = null
)
