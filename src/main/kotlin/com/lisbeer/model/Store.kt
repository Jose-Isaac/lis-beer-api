package com.lisbeer.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "stores")
class Store(
    @Id
    @GeneratedValue
    val id: UUID?,

    @Column(unique = true, nullable = false)
    val name: String,

    val evaluation: Double = 0.0,

    @Column(unique = true, nullable = false)
    val photoUrl: String,
)
