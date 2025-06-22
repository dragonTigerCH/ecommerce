package com.dt.ecommerce.domain.product

import com.dt.ecommerce.domain.common.PK

interface ProductProvider {
    fun load(pk: PK): Product?
}