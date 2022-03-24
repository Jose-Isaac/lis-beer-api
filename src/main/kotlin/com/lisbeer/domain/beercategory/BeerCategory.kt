package com.lisbeer.domain.beercategory

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.Table

@Entity
@Table(name = "beers_categories")
@IdClass(BeerCategoryId::class)
class BeerCategory(
    @Id
    val beerId: UUID,

    @Id
    val categoryId: UUID
)
