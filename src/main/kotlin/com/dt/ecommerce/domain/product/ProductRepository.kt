package com.dt.ecommerce.domain.product

import com.dt.ecommerce.domain.common.PK

interface ProductRepository {
    fun findBy(pk: PK): Product?
}