package com.lisbeer.infrastructure.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.lisbeer.application.users.UserDetailsImp
import com.lisbeer.domain.security.Credential
import com.lisbeer.infrastructure.security.jwt.JWTUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(
    private val authManager: AuthenticationManager,
    private val jwtUtil: JWTUtil
) : UsernamePasswordAuthenticationFilter() {

    init {
        setFilterProcessesUrl("/users/signin")
    }

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication {
        try {
            val (email, password) = ObjectMapper().readValue(request.inputStream, Credential::class.java)
            val token = UsernamePasswordAuthenticationToken(email, password, arrayListOf())
            return authManager.authenticate(token)
        } catch (e: Exception) {
            throw UsernameNotFoundException("")
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        chain: FilterChain?,
        authResult: Authentication
    ) {
        val username = (authResult.principal as UserDetailsImp).username
        val token = jwtUtil.generateToken(username)
        return response.addHeader("Authorization", "Bearer $token")
    }
}