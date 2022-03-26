package com.lisbeer.infrastructure.repositories.beers

import com.lisbeer.domain.beers.Beer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BeersRepository : JpaRepository<Beer, UUID> {
    override fun findAll(): List<Beer>

    fun findAllByStoreId(storeId: UUID): List<Beer>
}
