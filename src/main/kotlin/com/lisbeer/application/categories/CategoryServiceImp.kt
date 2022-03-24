package com.lisbeer.application.categories

import com.lisbeer.domain.categories.CategoryService
import com.lisbeer.domain.categories.CategoryVO
import com.lisbeer.domain.categories.toEntity
import com.lisbeer.domain.categories.toVO
import com.lisbeer.infrastructure.repositories.categories.CategoriesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CategoryServiceImp(
    @Autowired private val categoriesRepository: CategoriesRepository
) : CategoryService{
    override fun save(category: CategoryVO): Optional<CategoryVO> {

        return try {
            val exist = categoriesRepository.existsByName(category.name)

            if (exist) {
                Optional.empty()
            } else {
                val result = categoriesRepository.save(category.toEntity())
                Optional.of(result.toVO())
            }
        } catch (e: Exception) {
            Optional.empty()
        }
    }

    override fun findAll() : List<CategoryVO>  {
        return categoriesRepository.findAll().map { it.toVO() }
    }
}