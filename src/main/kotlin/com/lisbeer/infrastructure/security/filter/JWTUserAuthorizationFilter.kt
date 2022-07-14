package com.lisbeer.infrastructure.security.filter

import com.lisbeer.application.users.UserDetailServiceImp
import com.lisbeer.infrastructure.security.jwt.JWTUtil
import org.springframework.security.authentication.AuthenticationManager

class JWTUserAuthorizationFilter(
    authManager: AuthenticationManager,
    jwtUtil: JWTUtil,
    userDetailsService: UserDetailServiceImp
) : BaseAuthorizationFilter(jwtUtil, userDetailsService, authManager)