package com.lisbeer.domain.beers

import com.lisbeer.domain.categories.Category
import com.lisbeer.domain.stores.Store
import java.math.BigDecimal
import java.util.*
import javax.persistence.*

@Entity
@Table(
    name = "beers",
    indexes = [Index(name = "beers_pid_index", columnList = "publicId", unique = true)]
)
data class Beer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(unique = true, nullable = false)
    val publicId: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val name: String,

    @Column
    val evaluation: Double = 0.0,

    @Column
    val brand: String,

    @Column(unique = true, nullable = false)
    val price: BigDecimal,

    @Column(unique = true, nullable = false)
    val photoUrl: String,

    @ManyToMany
    val categories: List<Category>,

    @ManyToOne
    @JoinColumn(name = "storeId", nullable = false)
    val store: Store
)
