package com.lisbeer.domain.categories

fun CategoryVO.toEntity() = Category(
    id = this.id,
    name = this.name,
    evaluation = this.evaluation
)

fun Category.toVO() = CategoryVO(
    id = this.id,
    name = this.name,
    evaluation = this.evaluation
)