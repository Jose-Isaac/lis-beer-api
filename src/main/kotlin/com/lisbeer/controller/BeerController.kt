package com.lisbeer.controller

import com.lisbeer.model.Beer
import com.lisbeer.model.Categories
import com.lisbeer.model.dto.BeerDTO
import com.lisbeer.model.dto.CategoriesDTO
import com.lisbeer.repositories.BeerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.validation.Valid

@Service
@RestController
@RequestMapping(
    path = ["/beers"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class BeerController(
    val beerRepository: BeerRepository
) {

    @GetMapping
    fun getAllBeers(): MutableList<Beer> = beerRepository.findAll()

    @PostMapping
    fun createCategories(@Valid @RequestBody beer: BeerDTO): Beer {
        val isExist = beerRepository.existsByName(beer.name)

        return if (isExist)
            throw ResponseStatusException(HttpStatus.CONFLICT, "this beer name already exists")
        else beerRepository.save(beer.toBeer())
    }
}
