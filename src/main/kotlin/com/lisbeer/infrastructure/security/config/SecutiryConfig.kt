package com.lisbeer.infrastructure.security.config

import com.lisbeer.application.store.StoreDetailServiceImp
import com.lisbeer.application.users.UserDetailServiceImp
import com.lisbeer.infrastructure.security.encodePassword
import com.lisbeer.infrastructure.security.filter.JWTStoreAuthenticationFilter
import com.lisbeer.infrastructure.security.filter.JWTStoreAuthorizationFilter
import com.lisbeer.infrastructure.security.filter.JWTUserAuthenticationFilter
import com.lisbeer.infrastructure.security.filter.JWTUserAuthorizationFilter
import com.lisbeer.infrastructure.security.jwt.JWTUtil
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
class SecurityConfig(
    @Qualifier("UserDetailServiceImp")
    private val userDetailsService: UserDetailServiceImp,
    @Qualifier("StoreDetailServiceImp")
    private val storeDetailsService: StoreDetailServiceImp,
    private val jwtUtil: JWTUtil
) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(userDetailsService)
                .passwordEncoder(encodePassword())

        auth
            .userDetailsService(storeDetailsService)
            .passwordEncoder(encodePassword())
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signin").permitAll()
                .antMatchers(HttpMethod.POST, "/stores/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/stores/signin").permitAll()
            .anyRequest().authenticated()

        http
            .addFilter(JWTUserAuthenticationFilter(authenticationManager(), jwtUtil = jwtUtil))
            .addFilter(JWTUserAuthorizationFilter(authenticationManager(), jwtUtil = jwtUtil, userDetailsService = userDetailsService))
            .addFilter(JWTStoreAuthenticationFilter(authenticationManager(), jwtUtil = jwtUtil))
            .addFilter(JWTStoreAuthorizationFilter(authenticationManager(), jwtUtil = jwtUtil, storeDetailsService = storeDetailsService))

        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}