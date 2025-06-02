package com.dt.ecommerce.domain.cart

import com.dt.ecommerce.domain.common.PK

interface CartRepository {

    fun findBy(pk: PK): Cart?

    fun save(cart: Cart): Cart
}