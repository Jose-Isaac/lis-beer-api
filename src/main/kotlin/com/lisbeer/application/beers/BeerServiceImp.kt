package com.lisbeer.application.beers

import com.lisbeer.domain.beers.BeerService
import com.lisbeer.domain.beers.BeerVO
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerServiceImp: BeerService {
    override fun findAll(orderBy: String, evaluation: Boolean): List<BeerVO> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Optional<BeerVO> {
        TODO("Not yet implemented")
    }

    override fun create(beer: BeerVO): BeerVO {
        TODO("Not yet implemented")
    }
}