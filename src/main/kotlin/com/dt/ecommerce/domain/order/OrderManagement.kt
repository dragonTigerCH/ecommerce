package com.dt.ecommerce.domain.order

import org.springframework.stereotype.Service

interface OrderManagement {
    fun place(order: Order): Order
}

@Service
data class OrderService(
    private val repository: OrderRepository
): OrderManagement {
    override fun place(order: Order): Order {
        TODO("Not yet implemented")
    }
}