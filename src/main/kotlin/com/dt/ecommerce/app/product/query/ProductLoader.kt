package com.dt.ecommerce.app.product.query

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.product.Product
import com.dt.ecommerce.domain.product.ProductProvider
import com.dt.ecommerce.domain.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductLoader(
    private val repository: ProductRepository
): ProductProvider {
    override fun load(pk: PK): Product? {
        return repository.findBy(pk)
    }
}