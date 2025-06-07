package com.dt.ecommerce.app.order.command

import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderManagement
import com.dt.ecommerce.domain.order.OrderRepository
import org.springframework.stereotype.Service

@Service
data class OrderService(
    private val repository: OrderRepository
): OrderManagement {
    override fun place(order: Order): Order {
        TODO("Not yet implemented")
    }
}