package com.dt.ecommerce.domain.product

import com.dt.ecommerce.domain.common.PK
import jakarta.websocket.Decoder
import java.math.BigDecimal
import java.time.LocalDateTime

data class Product(
    var pk: PK = PK.NULL,
    val sku: String,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val discountPrice: BigDecimal? = null,
    val stockQuantity: Int,
    val category: String,
    val weight: Double? = null,
    val brand: String? = null,
    val isActive: Boolean = true,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)