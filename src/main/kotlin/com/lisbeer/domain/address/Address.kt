package com.lisbeer.domain.address

import javax.persistence.*

@Entity
@Table
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val street: String,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    val state: String,

    @Column(nullable = false)
    val postalCode: String,

    @Column(nullable = false)
    val country: String,

    @Column(nullable = false)
    val number: Int,

    @Column(nullable = true)
    val complement: String? = null
)
