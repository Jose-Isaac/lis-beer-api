package com.lisbeer.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Categories(
    @Id
    @GeneratedValue
    val id: UUID?,

    @Column(unique = true, nullable = false)
    val name: String,

    @Column(nullable = false)
    val evaluation: Int = 0
)
