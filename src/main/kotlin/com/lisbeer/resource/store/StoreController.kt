package com.lisbeer.resource.store


import com.lisbeer.domain.stores.StoreService
import com.lisbeer.domain.stores.StoreVO
import com.lisbeer.resource.store.representation.StoreRepresentation
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Service
@RestController
@RequestMapping(
    path = ["/stores"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
@Validated
class StoreController(
    val storeService: StoreService
) {
//    @GetMapping("/beers/{id}")
//    fun getStoresWithBeerId(@PathVariable id: UUID): List<Store> = listOf()

    @PostMapping
    fun create(@Valid @RequestBody store: StoreRepresentation): StoreVO {
        return storeService.create(store.toVO())
    }

    @GetMapping
    fun findAll(): List<StoreVO> {
        return storeService.findAll()
    }
}