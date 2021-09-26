package com.lisbeer.repositories;

import com.lisbeer.model.Beer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BeerRepository : JpaRepository<Beer, UUID> {
    abstract fun existsByName(name: String): Boolean
}