package com.lisbeer.infrastructure.security.filter

import com.lisbeer.application.store.StoreDetailServiceImp
import com.lisbeer.infrastructure.security.jwt.JWTUtil
import org.springframework.security.authentication.AuthenticationManager

class JWTStoreAuthorizationFilter(
    authManager: AuthenticationManager,
    jwtUtil: JWTUtil,
    storeDetailsService: StoreDetailServiceImp
) : BaseAuthorizationFilter(jwtUtil, storeDetailsService, authManager) {

}