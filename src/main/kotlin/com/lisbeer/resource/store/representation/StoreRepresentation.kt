package com.lisbeer.resource.store.representation

import com.lisbeer.domain.stores.StoreVO
import com.lisbeer.resource.address.representation.AddressRepresentation
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class StoreRepresentation(

    @NotEmpty
    val fantasyName: String,

    @Email
    val email: String,

    @NotEmpty
    @Size(min = 8, message = "A senha deve conter pelo menos 8 caracteres")
    val password: String,

    @NotEmpty
    val photoUrl: String,

    @NotEmpty
    val address: AddressRepresentation
) {
    fun toVO() = StoreVO(
        fantasyName = this.fantasyName,
        email = this.email,
        password = this.password,
        photoUrl = this.photoUrl,
        address = this.address.toVO()
    )
}