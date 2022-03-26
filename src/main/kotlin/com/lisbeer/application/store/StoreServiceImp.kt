package com.lisbeer.application.store

import com.lisbeer.domain.address.toEntity
import com.lisbeer.domain.address.toVO
import com.lisbeer.domain.beers.BeerService
import com.lisbeer.domain.stores.StoreService
import com.lisbeer.domain.stores.StoreVO
import com.lisbeer.domain.stores.toEntityWithPasswordEncode
import com.lisbeer.domain.stores.toVO
import com.lisbeer.infrastructure.repositories.address.AddressRepository
import com.lisbeer.infrastructure.repositories.stores.StoreRepository
import com.lisbeer.infrastructure.security.encodePassword
import org.springframework.stereotype.Service
import java.util.*

@Service
class StoreServiceImp(
    private val storeRepository: StoreRepository,
    private val addressRepository: AddressRepository,
    private val beerService: BeerService
): StoreService {
    override fun create(store: StoreVO): StoreVO {
        val encodedPassword = encodePassword().encode(store.password)

        val address = addressRepository.save(store.address.toEntity())

        val result = storeRepository.save(store.toEntityWithPasswordEncode(encodedPassword, address.id))

        // TODO tratar retorno null, sqlexception, connection error

        return result.toVO(address.toVO())
    }

    override fun findAll(): List<StoreVO> {
        return storeRepository.findAll().map {
            val address = addressRepository.findById(it.addressId)
            it.toVO(address.get().toVO())
        }
    }

    override fun findById(id: UUID): Optional<StoreVO> {
        val optional = storeRepository.findById(id)

        if (optional.isPresent) {
            val address = addressRepository.findById(optional.get().addressId)

            val store = optional.get().toVO(address.get().toVO())

            val beers = beerService.findAllByStoreId(id)

            store.beers = beers

            return Optional.of(store)
        }

        return Optional.empty()
    }
}