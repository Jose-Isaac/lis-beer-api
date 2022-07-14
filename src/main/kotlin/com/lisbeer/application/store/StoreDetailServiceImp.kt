package com.lisbeer.application.store

import com.lisbeer.infrastructure.repositories.stores.StoreRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service("StoreDetailServiceImp")
class StoreDetailServiceImp(
    private val storeRepository: StoreRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val entity = storeRepository.findByEmail(email)

        if (entity.isPresent) {
            return StoreDetailsImp(entity.get())
        }

        throw UsernameNotFoundException(email)
    }
}