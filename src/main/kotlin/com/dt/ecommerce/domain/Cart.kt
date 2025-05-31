package com.dt.ecommerce.domain

import java.time.LocalDateTime

data class Cart(
    var id: Long,
    val user: User,
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