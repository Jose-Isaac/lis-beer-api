package com.lisbeer.application.beers

import com.lisbeer.domain.beercategory.BeerCategory
import com.lisbeer.domain.beers.BeerService
import com.lisbeer.domain.beers.BeerVO
import com.lisbeer.domain.beers.toEntity
import com.lisbeer.domain.beers.toVO
import com.lisbeer.domain.categories.toVO
import com.lisbeer.infrastructure.repositories.BeersCategoriesRepository.BeerCategoryRepository
import com.lisbeer.infrastructure.repositories.beers.BeersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerServiceImp(
    private val beersRepository: BeersRepository,
    private val beerCategoryRepository: BeerCategoryRepository
): BeerService {
    override fun findAll(orderBy: String, evaluation: Boolean): List<BeerVO> {
        val beers = beersRepository.findAll()

        return beers.map { beer ->
            val categories = beerCategoryRepository.findCategoriesByBeerId(beer.id)

            beer.toVO(categories.map { it.toVO() })
        }
    }

    override fun findById(id: Long): Optional<BeerVO> {
        TODO("Not yet implemented")
    }

    override fun create(beer: BeerVO, categoriesId: List<String>): BeerVO {
        val result = beersRepository.save(beer.toEntity())

        categoriesId.forEach {
            beerCategoryRepository.save(BeerCategory(result.id, UUID.fromString(it)))
        }

        val categories = beerCategoryRepository.findCategoriesByBeerId(result.id)

        return result.toVO(categories.map { it.toVO() })
    }

    override fun findAllByStoreId(storeId: UUID): List<BeerVO> {
        val beers = beersRepository.findAllByStoreId(storeId)

        return beers.map { beer ->
            val categories = beerCategoryRepository.findCategoriesByBeerId(beer.id)

            beer.toVO(categories.map { it.toVO() })
        }
    }
}