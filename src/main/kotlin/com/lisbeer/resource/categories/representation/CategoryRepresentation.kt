package com.lisbeer.resource.categories.representation

import com.lisbeer.domain.categories.CategoryVO
import javax.validation.constraints.NotEmpty

data class CategoryRepresentation(
    @NotEmpty
    val name: String,
) {
    fun toVO() = CategoryVO(
        name = this.name,
    )
}
