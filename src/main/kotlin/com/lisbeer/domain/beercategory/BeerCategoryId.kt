package com.lisbeer.domain.beercategory

import java.util.*

class BeerCategoryId() : java.io.Serializable {

    lateinit var beerId: UUID
    lateinit var categoryId: UUID

    constructor(beerId: UUID, categoryId: UUID): this() {
        this.beerId = beerId
        this.categoryId = categoryId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BeerCategoryId

        if (beerId != other.beerId) return false
        if (categoryId != other.categoryId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = beerId.hashCode()
        result = 31 * result + categoryId.hashCode()
        return result
    }
}