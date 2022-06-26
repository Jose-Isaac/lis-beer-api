package com.lisbeer.application.users

import com.lisbeer.infrastructure.repositories.users.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImp(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val entity = userRepository.findByEmail(email)

        if (entity.isPresent) {
            return UserDetailsImp(entity.get())
        }

        throw UsernameNotFoundException(email)
    }
}