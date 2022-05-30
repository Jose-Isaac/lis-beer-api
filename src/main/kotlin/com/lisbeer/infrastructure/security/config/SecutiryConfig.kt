package com.lisbeer.infrastructure.security.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${api.security.user.password}")
    private lateinit var userPassword: String

    @Value("\${api.security.admin.password}")
    private lateinit var adminPassword: String

    val passwordEncoder: PasswordEncoder =
        PasswordEncoderFactories.createDelegatingPasswordEncoder()

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .inMemoryAuthentication()
            .withUser("user")
            .password(passwordEncoder.encode(userPassword))
            .roles("USER")
            .and()
            .withUser("admin")
            .password(passwordEncoder.encode(adminPassword))
            .roles("USER", "ADMIN")
    }

    override fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/healthcheck")
                .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()

        http.csrf().disable()
    }
}