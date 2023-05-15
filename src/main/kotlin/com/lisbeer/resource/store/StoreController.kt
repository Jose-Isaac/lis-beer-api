package com.lisbeer.resource.store

import com.lisbeer.domain.stores.StoreService
import com.lisbeer.domain.stores.StoreVO
import com.lisbeer.domain.stores.toDetailsResponse
import com.lisbeer.resource.store.representation.StoreDetailsResponseRepresentation
import com.lisbeer.resource.store.representation.StoreRepresentation
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@Service
@RestController
@RequestMapping(
    path = ["/stores"],
    produces = [MediaType.APPLICATION_JSON_VALUE],
)
@Validated
class StoreController(
    val storeService: StoreService,
) {

    @PostMapping("/signup")
    fun create(
        @Valid @RequestBody
        store: StoreRepresentation,
    ): StoreVO {
        return storeService.create(store.toVO())
    }

    @GetMapping
    fun findAll(): List<StoreVO> {
        return storeService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): StoreDetailsResponseRepresentation {
        val optional = storeService.findById(id)

        if (optional.isPresent) {
            return optional.get().toDetailsResponse()
        }

        // TODO adicionar tratamento de retorno
        return optional.get().toDetailsResponse()
    }
}
