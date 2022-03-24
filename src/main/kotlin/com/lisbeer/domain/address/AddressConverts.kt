package com.lisbeer.domain.address

fun AddressVO.toEntity() = Address(
    id = this.id,
    street = this.street,
    city = this.city,
    state = this.state,
    postalCode = this.postalCode,
    country = this.country,
    houseNumber = this.houseNumber,
    complement = this.complement
)

fun Address.toVO() = AddressVO(
    id = this.id,
    street = this.street,
    city = this.city,
    state = this.state,
    postalCode = this.postalCode,
    country = this.country,
    houseNumber = this.houseNumber,
    complement = this.complement
)