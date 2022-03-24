package com.lisbeer.application.store

import com.lisbeer.application.security.encodePassword
import com.lisbeer.domain.address.toEntity
import com.lisbeer.domain.address.toVO
import com.lisbeer.domain.stores.*
import com.lisbeer.infrastructure.repositories.address.AddressRepository
import com.lisbeer.infrastructure.repositories.stores.StoreRepository
import org.springframework.stereotype.Service

@Service
class StoreServiceImp(
    private val storeRepository: StoreRepository,
    private val addressRepository: AddressRepository
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
}