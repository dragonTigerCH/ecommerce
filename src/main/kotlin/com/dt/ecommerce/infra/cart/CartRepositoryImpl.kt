package com.dt.ecommerce.infra.cart

import com.dt.ecommerce.domain.cart.Cart
import com.dt.ecommerce.domain.cart.CartRepository
import com.dt.ecommerce.domain.common.PK
import org.springframework.stereotype.Repository

@Repository
class CartRepositoryImpl(
    private val repository: CartJpaRepository
) : CartRepository {

    override fun findBy(pk: PK): Cart? {
        TODO("Not yet implemented")
    }

    override fun save(cart: Cart): Cart {
        TODO("Not yet implemented")
    }

}