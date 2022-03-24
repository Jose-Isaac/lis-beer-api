package com.lisbeer.domain.stores

interface StoreService {
    fun create(store: StoreVO): StoreVO
    fun findAll(): List<StoreVO>
}