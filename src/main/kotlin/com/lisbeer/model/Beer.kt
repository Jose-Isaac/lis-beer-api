package com.lisbeer.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
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
