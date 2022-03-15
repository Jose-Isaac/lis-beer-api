package com.lisbeer.domain.categories

import com.lisbeer.resource.categories.representation.CategoryRepresentation

fun CategoryVO.toEntity() = Categories(
    id = this.id ?: 0L,
    name = this.name,
    evaluation = this.evaluation
)

fun Categories.toVO() = CategoryVO(
    id = this.id,
    name = this.name,
    evaluation = this.evaluation
)

fun CategoryRepresentation.toVO() = CategoryVO(
    name = this.name,
)