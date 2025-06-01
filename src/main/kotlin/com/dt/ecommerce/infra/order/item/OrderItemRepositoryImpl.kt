package com.dt.ecommerce.infra.order.item

import com.dt.ecommerce.domain.order.item.OrderItem
import com.dt.ecommerce.domain.order.item.OrderItemRepository
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryImpl(
    private val jpaRepository: OrderItemJpaRepository
): OrderItemRepository {
    override fun findBy(id: Long): OrderItem? {
        TODO("Not yet implemented")
    }

    override fun findByOrderId(orderId: Long): List<OrderItem> {
        TODO("Not yet implemented")
    }

    override fun save(orderItem: OrderItem): OrderItem {
        TODO("Not yet implemented")
    }

}