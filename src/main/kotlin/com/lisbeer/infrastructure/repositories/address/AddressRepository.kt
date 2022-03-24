package com.lisbeer.infrastructure.repositories.address

import com.lisbeer.domain.address.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AddressRepository: JpaRepository<Address, UUID> {
}