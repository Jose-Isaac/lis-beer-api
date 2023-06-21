package com.lisbeer.resource.address.representation

import com.lisbeer.domain.address.AddressVO
import javax.validation.constraints.NotEmpty

data class AddressRepresentation(
    @NotEmpty
    val street: String,

    @NotEmpty
    val city: String,

    @NotEmpty
    val state: String,

    @NotEmpty
    val postalCode: Int,

    @NotEmpty
    val country: String,

    @NotEmpty
    val houseNumber: Int,

    val complement: String? = null,
) {
    fun toVO() = AddressVO(
        street = this.street,
        city = this.city,
        state = this.state,
        postalCode = this.postalCode,
        country = this.country,
        houseNumber = this.houseNumber,
        complement = this.complement,
    )
}
