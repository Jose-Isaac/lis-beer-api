package com.lisbeer.application.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

fun encode(): PasswordEncoder {
    return BCryptPasswordEncoder()
}