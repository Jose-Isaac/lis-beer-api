package com.lisbeer.domain.categories

import java.math.BigDecimal
import java.util.UUID
import javax.persistence.*

@Entity
@Table(
    name = "categories",
    indexes = [Index(name = "categories_pid_index", columnList = "publicId", unique = true)]
)
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(unique = true, nullable = false)
    val publicId: UUID = UUID.randomUUID(),

    @Column(unique = true, nullable = false)
    val name: String,

    @Column(nullable = false)
    val evaluation: Double = 0.0
)
