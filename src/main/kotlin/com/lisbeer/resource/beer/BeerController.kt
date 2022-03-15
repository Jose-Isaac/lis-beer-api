package com.lisbeer.resource.beer

import com.lisbeer.model.Beer
import com.lisbeer.model.dto.BeerDTO
import com.lisbeer.repositories.BeerRepository
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
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
    fun getAllBeers(@RequestParam evaluation: Boolean = false): List<Beer> {
        return if (evaluation) {
            beerRepository.findAllOrderByEvaluation(Sort.by(Sort.Direction.ASC, "evaluation"))
        } else { beerRepository.findAll() }
    }

    @GetMapping("/{id}")
    fun getBeerById(@PathVariable id: UUID): Beer = beerRepository
        .findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

    @PostMapping
    fun createCategories(@Valid @RequestBody beer: BeerDTO): Beer {
        val isExist = beerRepository.existsByName(beer.name)

        return if (isExist)
            throw ResponseStatusException(HttpStatus.CONFLICT, "this beer name already exists")
        else beerRepository.save(beer.toBeer())
    }
}
