package com.lisbeer.resource.users.representation

import com.lisbeer.domain.users.UserVO
import com.lisbeer.infrastructure.security.encodePassword

data class UserRepresentation(
    val email: String,
    val password: String
) {
    fun toVO(): UserVO {
        return UserVO(
            email = this.email,
            password = encodePassword().encode(this.password)
        )
    }
}
