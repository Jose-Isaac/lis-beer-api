package com.lisbeer.resource.categories

import com.lisbeer.domain.categories.CategoriesService
import com.lisbeer.domain.categories.CategoryVO
import com.lisbeer.domain.categories.Categories
import com.lisbeer.resource.categories.representation.CategoryRepresentation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.validation.Valid

@Service
@RestController
@RequestMapping(
    path = ["/categories"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class CategoriesController(
    @Autowired private val categoriesService: CategoriesService
) {
    @GetMapping
    fun getAllCategories(): List<CategoryVO> = categoriesService.findAll()

    @PostMapping
    fun create(@Valid @RequestBody category: CategoryRepresentation): CategoryVO {

        // TODO melhorar a forma de retorno de erros para o usuário

        val result = categoriesService.save(category.toVO())

        return if (result.isPresent) {
            result.get()
        } else {
            throw ResponseStatusException(HttpStatus.CONFLICT, "this category already exists")
        }
    }
}
