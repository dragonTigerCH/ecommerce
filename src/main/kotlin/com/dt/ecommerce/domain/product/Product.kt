package com.dt.ecommerce.domain.product

import com.dt.ecommerce.domain.common.Audit
import com.dt.ecommerce.domain.common.PK
import jakarta.websocket.Decoder
import java.math.BigDecimal
import java.time.LocalDateTime

data class Product(
    var pk: PK = PK.NULL,
    val name: String,
    val description: String? = null,
    val price: BigDecimal,
    val stock: Stock,
    val categories: List<ProductCategory>,
    val isActive: Boolean = true,
    val audit: Audit,
)

data class ProductCategory(
    val category: Category,
    val product: Product,

    val isMain: Boolean = false,
    val audit: Audit,
)


data class Category(
    val pk: PK = PK.NULL,
    val name: String,
    val audit: Audit,
)

data class Stock(
    val product: Product,
    val quantity: Int
)