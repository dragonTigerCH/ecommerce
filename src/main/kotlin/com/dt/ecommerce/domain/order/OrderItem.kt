package com.dt.ecommerce.domain.order

import java.math.BigDecimal
import java.time.LocalDateTime

data class OrderItem(
    var id: Long? = null,
    val orderId: Long,
    val productId: Long,
    val productSku: String,
    val productName: String,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val discount: BigDecimal = BigDecimal.ZERO,
    val subtotal: BigDecimal,
    val attributes: Map<String, String> = emptyMap(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)