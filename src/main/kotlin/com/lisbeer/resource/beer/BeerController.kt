package com.lisbeer.resource.beer

import com.lisbeer.domain.beers.BeerService
import com.lisbeer.domain.beers.BeerVO
import org.intellij.lang.annotations.Pattern
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
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
    fun getAllBeers(
        @RequestParam evaluation: Boolean = false,
        @Valid @Pattern("DESC|ASC") @RequestParam orderBy: String
    ): List<BeerVO> {
        return beerService.findAll(orderBy, evaluation)
    }

//    @GetMapping("/{id}")
//    fun getBeerById(@PathVariable id: UUID): Beer = beersRepository
//        .findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
//
//    @PostMapping
//    fun createCategories(@Valid @RequestBody beer: BeerDTO): Beer {
//        val isExist = beersRepository.existsByName(beer.name)
//
//        return if (isExist)
//            throw ResponseStatusException(HttpStatus.CONFLICT, "this beer name already exists")
//        else beersRepository.save(beer.toBeer())
//    }
}
