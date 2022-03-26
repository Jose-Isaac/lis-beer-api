package com.lisbeer.domain.address

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
class Address(
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    val id: UUID,

    @Column(nullable = false)
    val street: String,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    val state: String,

    @Column(nullable = false)
    val postalCode: Int,

    @Column(nullable = false)
    val country: String,

    @Column(nullable = false)
    val houseNumber: Int,

    @Column(nullable = true)
    val complement: String? = null
)
