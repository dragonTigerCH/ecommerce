package com.dt.ecommerce.domain.cart

import com.dt.ecommerce.domain.common.Audit
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import java.time.LocalDateTime

data class Cart(
    val pk: PK = PK.NULL,
    val customer: PK,
    val items: List<CartItem>,
    val isActive: Boolean = false,

    val audit: Audit
)

class CartItem(
    val pk: PK = PK.NULL,
    val product: PK,

    val cart: Cart,
    val quantity: Int,

    val audit: Audit
)