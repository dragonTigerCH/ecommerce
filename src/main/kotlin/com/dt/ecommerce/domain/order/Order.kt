package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.common.Address
import com.dt.ecommerce.domain.common.Money
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.domain.order.item.OrderItem
import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    var pk: PK = PK.NULL,
    val items: List<OrderItem>,
    val orderDate: LocalDateTime = LocalDateTime.now(),
    val status: OrderStatus = OrderStatus.PENDING,
    val customer: Customer,
    val shippingAddress: Address,
    val billingAddress: Address,
    val totalAmount: Money,
    val tax: Money,
    val shippingCost: Money,
    val notes: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
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
            billingAddress: Address = Address.NONE
        ) = Order(
            items = items,
            customer = customer,
            totalAmount = totalAmount,
            shippingAddress = shippingAddress,
            billingAddress = billingAddress,
            tax = Money(),
            shippingCost = Money(),
        )
    }
}
