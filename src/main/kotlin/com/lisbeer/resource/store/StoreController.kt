package com.lisbeer.resource.store

import com.lisbeer.model.Store
import com.lisbeer.repositories.StoreRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@Service
@RestController
@RequestMapping(
    path = ["/stores"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class StoreController(
    val storeRepository: StoreRepository
) {
    @GetMapping("/beers/{id}")
    fun getStoresWithBeerId(@PathVariable id: UUID): List<Store> = listOf()
}