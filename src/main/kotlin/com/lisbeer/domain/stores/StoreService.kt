package com.lisbeer.domain.stores

import java.util.*

interface StoreService {
    fun create(store: StoreVO): StoreVO
    fun findAll(): List<StoreVO>
    fun findById(id: UUID): Optional<StoreVO>
}