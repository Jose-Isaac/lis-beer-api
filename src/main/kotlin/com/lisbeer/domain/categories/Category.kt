package com.lisbeer.domain.categories

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(
    name = "categories"
)
class Category(
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    val id: UUID,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val evaluation: Double
)
