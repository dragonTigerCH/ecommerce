package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.common.Address
import com.dt.ecommerce.domain.common.Money
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    val pk: PK = PK.NULL,
    val customer: PK,

    val items: List<OrderItem>,
    val status: OrderStatus = OrderStatus.PENDING,

    val totalAmount: Money,
    val shippingAddress: Address,

    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime? = null,
    val notes: String? = null,
) {
    enum class OrderStatus {
        PENDING, PROCESSING, PAID, SHIPPED, DELIVERED, CANCELLED, REFUNDED
    }

    companion object {
        fun create(
            items: List<OrderItem>,
            customer: PK,
            totalAmount: Money,
            shippingAddress: Address = Address.NONE,
        ) = Order(
            items = items,
            customer = customer,
            totalAmount = totalAmount,
            shippingAddress = shippingAddress,
            createdAt = LocalDateTime.now()
        )
    }
}


data class OrderItem(
    val pk: PK = PK.NULL,
    val product: PK,

    val order: Order,

    val name: String,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val createdAt: LocalDateTime
)
