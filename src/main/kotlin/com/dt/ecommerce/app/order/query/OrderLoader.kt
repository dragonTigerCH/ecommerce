package com.dt.ecommerce.app.order.query

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderProvider
import com.dt.ecommerce.domain.order.OrderRepository
import org.springframework.stereotype.Service

@Service
data class OrderLoader(
    private val orderRepository: OrderRepository
): OrderProvider {
    override fun load(key: PK): Order? {
        return orderRepository.findBy(key)
    }
}