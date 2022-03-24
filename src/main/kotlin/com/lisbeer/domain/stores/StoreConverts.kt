package com.lisbeer.domain.stores

import com.lisbeer.domain.address.AddressVO
import java.util.*

fun StoreVO.toEntityWithPasswordEncode(encodedPassword: String, addressId: UUID) = Store(
    id = this.id,
    fantasyName = this.fantasyName,
    accessRule = this.accessRule,
    email = this.email,
    password = encodedPassword,
    evaluation = this.evaluation,
    photoUrl = this.photoUrl,
    addressId = addressId
)

fun StoreVO.toEntity(addressId: UUID) = Store(
    id = this.id,
    fantasyName = this.fantasyName,
    accessRule = this.accessRule,
    email = this.email,
    password = this.password,
    evaluation = this.evaluation,
    photoUrl = this.photoUrl,
    addressId = addressId
)

fun Store.toVO(address: AddressVO) = StoreVO(
    id = this.id,
    fantasyName = this.fantasyName,
    accessRule = this.accessRule,
    email = this.email,
    password = this.password,
    evaluation = this.evaluation,
    photoUrl = this.photoUrl,
    address = address
)