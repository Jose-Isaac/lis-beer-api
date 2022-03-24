package com.lisbeer.domain.stores

import com.lisbeer.application.rules.Access
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email

@Entity
@Table(
    name = "stores"
)
class Store(
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    val id: UUID,

    @Column(nullable = false, unique = true)
    val fantasyName: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val accessRule: Access,

    @Email
    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val evaluation: Double,

    @Column(nullable = false)
    val photoUrl: String,

    @Column(nullable = false)
    val addressId: UUID
)
