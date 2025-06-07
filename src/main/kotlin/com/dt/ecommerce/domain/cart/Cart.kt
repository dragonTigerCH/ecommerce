package com.dt.ecommerce.domain.cart

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import java.time.LocalDateTime

data class Cart(
    val pk: PK = PK.NULL,
    val customer: Customer,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val items: List<CartItem>
)

/**
 *  id
 * - cartId (FK)
 * - productId
 * - quantity
 * - selected (true/false)
 * - addedAt
 */
class CartItem(
    val productId: Long,
    val quantity: Int,
    val selected: Boolean,
    val addedAt: LocalDateTime
)