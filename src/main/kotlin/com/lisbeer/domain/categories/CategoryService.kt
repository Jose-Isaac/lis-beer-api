package com.lisbeer.domain.categories

import java.util.Optional

interface CategoryService {
    fun save(category: CategoryVO): Optional<CategoryVO>
    fun findAll(): List<CategoryVO>
}