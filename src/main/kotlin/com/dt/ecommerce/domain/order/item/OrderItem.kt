package com.dt.ecommerce.domain.order.item

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.Order
import java.math.BigDecimal
import java.time.LocalDateTime

data class OrderItem(
    var pk: PK = PK.NULL,
    val order: Order,
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