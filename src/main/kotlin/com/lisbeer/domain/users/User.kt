package com.lisbeer.domain.users

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(

    @Id
    @Column(updatable = false, unique = true, nullable = false)
    val id: UUID,

    @Column(updatable = false, unique = true, nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false, unique = true)
    val username: String
)
