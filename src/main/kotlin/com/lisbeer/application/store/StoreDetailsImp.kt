package com.lisbeer.application.store

import com.lisbeer.domain.stores.Store
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class StoreDetailsImp(
    private val store: Store
) : UserDetails {
    override fun getAuthorities() = mutableListOf<GrantedAuthority>()

    override fun getPassword() = store.password

    override fun getUsername() = store.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}