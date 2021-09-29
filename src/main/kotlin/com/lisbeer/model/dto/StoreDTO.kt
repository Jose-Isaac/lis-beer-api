package com.lisbeer.model.dto

import com.lisbeer.model.Store

class StoreDTO(
    val name: String,
    val evaluation: Double = 0.0,
    val photoUrl: String,
) {
    fun toStore(): Store = Store(null, name, evaluation, photoUrl)
}
