package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.domain.order.OrderItem
import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    val id: Long? = null,
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

data class Address(
    var id: Long? = null,
    val fullName: String,
    val line1: String,
    val detail: String? = null,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val phoneNumber: String
) {
    companion object {
        val NONE = Address(
            fullName = "",
            line1 = "",
            city = "",
            state = "",
            postalCode = "",
            country = "",
            phoneNumber = ""
        )
    }
}

data class Money(
    val amount: BigDecimal = BigDecimal.ZERO,
    val currency: String = "KRW"
)
