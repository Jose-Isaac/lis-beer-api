package com.lisbeer.infrastructure.repositories.stores

import com.lisbeer.domain.stores.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : JpaRepository<Store, Long>
