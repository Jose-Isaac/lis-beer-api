package com.lisbeer.repositories

import com.lisbeer.model.Categories
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CategoriesRepository : JpaRepository<Categories, UUID> {
    abstract fun existsByName(name: String): Boolean
}
