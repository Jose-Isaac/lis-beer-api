package com.lisbeer.resource.users.representation

import com.lisbeer.domain.users.UserVO

data class UserRepresentation(
    val email: String,
    val password: String,
    val username: String
) {
    fun toVO(): UserVO {
        return UserVO(
            email = this.email,
            password = this.password,
            username = this.username
        )
    }
}
