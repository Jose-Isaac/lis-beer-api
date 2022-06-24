package com.lisbeer.application.users

import com.lisbeer.domain.users.UserService
import com.lisbeer.domain.users.UserVO
import com.lisbeer.domain.users.toEntity
import com.lisbeer.domain.users.toVO
import com.lisbeer.infrastructure.repositories.users.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImp(
    private val userRepository: UserRepository
) : UserService{
    override fun create(user: UserVO): UserVO {
        return userRepository
            .save(user.toEntity())
            .toVO()
    }
}