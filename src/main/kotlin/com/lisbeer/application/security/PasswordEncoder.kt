package com.lisbeer.application.security

import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


fun encodePassword(): PasswordEncoder {
    return BCryptPasswordEncoder()
}

fun isEncoded(candidatePassword: String, passwordHash: String): Boolean {
    return BCrypt.checkpw(candidatePassword, passwordHash)
}