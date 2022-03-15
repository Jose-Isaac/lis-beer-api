package com.lisbeer.domain.categories

import javax.persistence.*

@Entity
class Categories(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(unique = true, nullable = false)
    val name: String,

    @Column(nullable = false)
    val evaluation: Double = 0.0
)
