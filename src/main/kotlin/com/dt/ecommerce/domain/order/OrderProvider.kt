package com.dt.ecommerce.domain.order

import org.springframework.stereotype.Service

interface OrderProvider {
    fun load(key: Long): Order
}

@Service
data class OrderLoader(
    private val orderRepository: OrderRepository
): OrderProvider {
    override fun load(key: Long): Order {
        return orderRepository.findBy(key)?: throw RuntimeException("Order Not Found")
    }
}