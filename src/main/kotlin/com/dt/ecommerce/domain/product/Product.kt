package com.dt.ecommerce.domain.product

import java.math.BigDecimal
import java.time.LocalDateTime

data class Product(
    var id: Long? = null,
    val sku: String,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val discountPrice: BigDecimal? = null,
    val stockQuantity: Int,
    val category: String,
    val images: List<String> = emptyList(),
    val weight: Double? = null,
    val brand: String? = null,
    val isActive: Boolean = true,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
)