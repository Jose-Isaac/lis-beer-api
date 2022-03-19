package com.lisbeer.infrastructure.repositories.beers

import com.lisbeer.domain.beers.Beer
import org.springframework.data.jpa.repository.JpaRepository

interface BeersRepository : JpaRepository<Beer, Long> {
    override fun findAll(): List<Beer>
}
