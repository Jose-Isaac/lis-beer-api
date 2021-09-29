package com.lisbeer.repositories

import com.lisbeer.model.Store
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StoreRepository : JpaRepository<Store, UUID>
