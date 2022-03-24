package com.lisbeer.domain.beers

import java.math.BigDecimal
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(
    name = "beers"
)
data class Beer(
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    val id: UUID,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val evaluation: Double,

    @Column(nullable = false)
    val brand: String,

    @Column(nullable = false)
    val price: BigDecimal,

    @Column(nullable = false)
    val photoUrl: String,

    @Column(nullable = false)
    val storeId: UUID
)
