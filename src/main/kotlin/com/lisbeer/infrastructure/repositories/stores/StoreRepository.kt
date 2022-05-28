package com.lisbeer.infrastructure.repositories.stores

import com.lisbeer.domain.stores.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StoreRepository : JpaRepository<Store, UUID>
