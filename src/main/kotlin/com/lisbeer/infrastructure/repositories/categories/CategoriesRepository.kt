package com.lisbeer.infrastructure.repositories.categories

import com.lisbeer.domain.categories.Categories
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriesRepository : JpaRepository<Categories, Long> {
    fun existsByName(name: String): Boolean
}
