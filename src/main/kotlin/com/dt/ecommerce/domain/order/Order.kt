package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.common.Address
import com.dt.ecommerce.domain.common.Money
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    var pk: PK = PK.NULL,
    val customer: Customer,

    val items: List<OrderItem>,
    val status: OrderStatus = OrderStatus.PENDING,

    val totalAmount: Money,
    val shippingAddress: Address,

    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null,
    val notes: String? = null,
) {
    enum class OrderStatus {
        PENDING, PROCESSING, PAID, SHIPPED, DELIVERED, CANCELLED, REFUNDED
    }

    companion object {
        fun create(
            items: List<OrderItem>,
            customer: Customer,
            totalAmount: Money,
            shippingAddress: Address = Address.NONE,
        ) = Order(
            items = items,
            customer = customer,
            totalAmount = totalAmount,
            shippingAddress = shippingAddress,
        )
    }
}


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
