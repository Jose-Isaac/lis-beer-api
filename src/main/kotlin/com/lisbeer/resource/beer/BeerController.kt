package com.lisbeer.resource.beer

import com.lisbeer.domain.beers.BeerService
import com.lisbeer.domain.beers.BeerVO
import com.lisbeer.resource.beer.representation.BeerDetailsResponseRepresentation
import com.lisbeer.resource.beer.representation.beerRepresentation
import org.intellij.lang.annotations.Pattern
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@Service
@RestController
@RequestMapping(
    path = ["/beers"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class BeerController(
    private val beerService: BeerService
) {

    @GetMapping
    fun findAll(
        @RequestParam evaluation: Boolean?,
        @Valid @Pattern("DESC|ASC") @RequestParam orderBy: String?
    ): List<BeerVO> {
        return beerService.findAll(orderBy ?: "DESC", evaluation ?: false)
    }

    @PostMapping
    fun create(@Valid @RequestBody beer: beerRepresentation): BeerVO {
        return beerService.create(beer.toVO(), beer.categories)
    }

    @GetMapping("/{id}")
    fun getBeerById(@PathVariable id: UUID): BeerDetailsResponseRepresentation {
        val optional = beerService.findById(id)

        if (optional.isPresent) {
            return optional.get()
        }

        // TODO adicionar tratamento de retorno
        return optional.get()
    }

    @GetMapping("/categories/{id}")
    fun findAllBeerByCategoryId(@PathVariable id: UUID): List<BeerVO> {
        return beerService.findAllByCategoryId(id)
    }
}
