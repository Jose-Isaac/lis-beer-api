package com.lisbeer.infrastructure.repositories.categories

import com.lisbeer.domain.categories.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriesRepository : JpaRepository<Category, Long> {
    fun existsByName(name: String): Boolean
}
