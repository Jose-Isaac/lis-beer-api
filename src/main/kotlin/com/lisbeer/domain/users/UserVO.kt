package com.lisbeer.domain.users

import java.util.*

data class UserVO(
    val id: UUID = UUID.randomUUID(),
    val email: String,
    val password: String
)
