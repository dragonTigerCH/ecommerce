package com.dt.ecommerce.infra.product

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.product.Product
import com.dt.ecommerce.domain.product.ProductRepository
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val jpaRepository: ProductJpaRepository
): ProductRepository {
    override fun findBy(pk: PK): Product? {
        TODO("Not yet implemented")
    }
}