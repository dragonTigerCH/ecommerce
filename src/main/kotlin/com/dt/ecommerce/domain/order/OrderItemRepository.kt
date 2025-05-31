package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.order.OrderItem

interface OrderItemRepository {
    fun findBy(id: Long): OrderItem?
    fun findByOrderId(orderId: Long): List<OrderItem>
    fun save(orderItem: OrderItem): OrderItem
}