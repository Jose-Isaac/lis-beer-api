package com.lisbeer.domain.users

interface UserService {
    fun create(user: UserVO): UserVO
}