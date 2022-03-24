package com.lisbeer.domain.categories

import java.util.UUID

data class CategoryVO(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val evaluation: Double = 0.0
)
