package com.lisbeer.repositories

import com.lisbeer.model.Beer
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface BeerRepository : JpaRepository<Beer, UUID> {
    override fun findAll(): MutableList<Beer>

    @Query("select b from Beer b where b.evaluation = ?1")
    fun findAllOrderByEvaluation(vararg sort: Sort): List<Beer>

    fun existsByName(name: String): Boolean
}
