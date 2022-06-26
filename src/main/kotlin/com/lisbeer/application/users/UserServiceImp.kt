package com.lisbeer.application.users

import com.lisbeer.domain.users.UserService
import com.lisbeer.domain.users.UserVO
import com.lisbeer.domain.users.toEntity
import com.lisbeer.domain.users.toVO
import com.lisbeer.infrastructure.repositories.users.UserRepository
import com.lisbeer.infrastructure.security.encodePassword
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImp(
    private val userRepository: UserRepository
) : UserService{
    override fun create(user: UserVO): UserVO {
        return userRepository
            .save(
                user.toEntity(
                    encodePassword().encode(user.password)
                )
            )
            .toVO()
        // TODO tratar exception de duplicate key
    }

    override fun myself(): Optional<UserVO> {
        val entity = userRepository.findByEmail(
            getCurrentUserEmail()
        )

        return if (entity.isPresent) {
            Optional.of(
                entity.get().toVO()
            )
        } else {
            Optional.empty()
        }
    }

    private fun getCurrentUserEmail(): String {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetailsImp
        return user.username
    }
}