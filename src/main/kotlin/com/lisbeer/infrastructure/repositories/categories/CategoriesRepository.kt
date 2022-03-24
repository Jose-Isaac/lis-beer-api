package com.lisbeer.infrastructure.repositories.categories

import com.lisbeer.domain.categories.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CategoriesRepository : JpaRepository<Category, UUID> {
    fun existsByName(name: String): Boolean
}
