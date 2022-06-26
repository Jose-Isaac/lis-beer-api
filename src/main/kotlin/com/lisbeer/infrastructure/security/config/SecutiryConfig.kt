package com.lisbeer.infrastructure.security.config

import com.lisbeer.infrastructure.security.encodePassword
import com.lisbeer.infrastructure.security.filter.JWTAuthenticationFilter
import com.lisbeer.infrastructure.security.filter.JWTAuthorizationFilter
import com.lisbeer.infrastructure.security.jwt.JWTUtil
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService


@Configuration
class SecurityConfig(
    private val userDetailsService: UserDetailsService,
    private val jwtUtil: JWTUtil
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(userDetailsService)
                .passwordEncoder(encodePassword())
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signin").permitAll()
            .anyRequest().authenticated()

        http
            .addFilter(JWTAuthenticationFilter(authenticationManager(), jwtUtil = jwtUtil))
            .addFilter(JWTAuthorizationFilter(authenticationManager(), jwtUtil = jwtUtil, userDetailsService = userDetailsService))

        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}