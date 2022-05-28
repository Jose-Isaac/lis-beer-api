package com.lisbeer.application.beers

import com.lisbeer.domain.beercategory.BeerCategory
import com.lisbeer.domain.beers.*
import com.lisbeer.domain.categories.toVO
import com.lisbeer.domain.stores.StoreService
import com.lisbeer.infrastructure.repositories.BeersCategoriesRepository.BeerCategoryRepository
import com.lisbeer.infrastructure.repositories.beers.BeersRepository
import com.lisbeer.resource.beer.representation.BeerDetailsResponseRepresentation
import org.springframework.stereotype.Service
import java.util.*

@Service
class BeerServiceImp(
    private val beersRepository: BeersRepository,
    private val beerCategoryRepository: BeerCategoryRepository,
    @org.springframework.context.annotation.Lazy private val storeService: StoreService
): BeerService {
    override fun findAll(orderBy: String, evaluation: Boolean): List<BeerVO> {
        val beers = beersRepository.findAll()

        return beers.map { beer ->
            val categories = beerCategoryRepository.findCategoriesByBeerId(beer.id)

            beer.toVO(categories.map { it.toVO() })
        }
    }

    override fun findById(id: UUID): Optional<BeerDetailsResponseRepresentation> {
        val optional = beersRepository.findById(id)

        if (optional.isPresent) {
            val categories = beerCategoryRepository.findCategoriesByBeerId(optional.get().id)

            val beer = optional.get().toVO(categories.map { it.toVO() })

            val store = storeService.findById(beer.storeId)

            return Optional.of(beer.toDetailsResponse(store.get()))
        }

        return Optional.empty()
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

    override fun findAllByCategoryId(categoryId: UUID): List<BeerVO> {
        val beers = beerCategoryRepository.findBeersByCategoryId(categoryId)

        return beers.map { beer ->
            val categories = beerCategoryRepository.findCategoriesByBeerId(beer.id)

            beer.toVO(categories.map { it.toVO() })
        }
    }
}