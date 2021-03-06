package com.lisbeer.infrastructure.security.filter

import com.lisbeer.infrastructure.security.jwt.JWTUtil
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BaseAuthorizationFilter(
    private val jwtUtil: JWTUtil,
    private val userDetailsService: UserDetailsService,
    authManager: AuthenticationManager
): BasicAuthenticationFilter(authManager) {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authorizationHeader: String? = request.getHeader("Authorization")

        try {
            if (authorizationHeader != null) {
                if (authorizationHeader.startsWith("Bearer")) {
                    val auth = getAuthentication(authorizationHeader)
                    SecurityContextHolder.getContext().authentication = auth
                }
            }
        } catch (e: UsernameNotFoundException) {
            println(e.message)
        } catch (e: Exception) {
            throw Exception(e.message)
        } finally {
            chain.doFilter(request, response)
        }
    }

    private fun getAuthentication(authorizationHeader: String?): UsernamePasswordAuthenticationToken {
        val token = authorizationHeader?.substring(7) ?: ""

        if (jwtUtil.isValidToken(token)) {
            val username = jwtUtil.getUserName(token)
            val user = userDetailsService.loadUserByUsername(username)
            return UsernamePasswordAuthenticationToken(user, null, user.authorities)
        }

        throw UsernameNotFoundException("Auth invalid!")
    }
}