package com.lisbeer.infrastructure.repositories.BeersCategoriesRepository

import com.lisbeer.domain.beercategory.BeerCategory
import com.lisbeer.domain.beercategory.BeerCategoryId
import com.lisbeer.domain.categories.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BeerCategoryRepository: JpaRepository<BeerCategory, BeerCategoryId> {
    @Query(
        "select c from Category c inner join BeerCategory bc on c.id = bc.categoryId where bc.beerId = ?1")
    fun findCategoriesByBeerId(beerId: UUID) : List<Category>
}