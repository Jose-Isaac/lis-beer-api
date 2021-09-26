package com.lisbeer.controller

import com.lisbeer.model.Categories
import com.lisbeer.model.dto.CategoriesDTO
import com.lisbeer.repositories.CategoriesRepository
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
    val categoriesRepository: CategoriesRepository
) {
    @GetMapping
    fun getAllCategories(): List<Categories> = categoriesRepository.findAll()

    @PostMapping
    fun createCategories(@Valid @RequestBody categorie: CategoriesDTO): Categories {
        val isExist = categoriesRepository.existsByName(categorie.name)

        return if (isExist)
            throw ResponseStatusException(HttpStatus.CONFLICT, "this category already exists")
        else categoriesRepository.save(categorie.toCategorie())
    }
}
