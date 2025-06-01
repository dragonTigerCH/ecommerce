package com.dt.ecommerce.domain.order.item

interface OrderItemRepository {
    fun findBy(id: Long): OrderItem?
    fun findByOrderId(orderId: Long): List<OrderItem>

    fun save(orderItem: OrderItem): OrderItem
}