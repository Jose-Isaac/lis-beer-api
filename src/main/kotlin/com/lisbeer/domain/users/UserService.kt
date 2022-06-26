package com.lisbeer.domain.users

import java.util.*

interface UserService {
    fun create(user: UserVO): UserVO
    fun myself(): Optional<UserVO>
}