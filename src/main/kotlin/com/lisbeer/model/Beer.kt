package com.lisbeer.model

import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "beers")
class Beer(
    @Id
    @GeneratedValue
    val id: UUID?,

    @Column(unique = true, nullable = false)
    val name: String,

    val evaluation: Double = 0.0,

    @Column(unique = true, nullable = false)
    val price: Double,
    @Column(unique = true, nullable = false)
    val photoUrl: String,
)
