package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.order.OrderItem
import com.dt.ecommerce.domain.order.OrderItemRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface OrderItemJpaRepository : OrderItemRepository, JpaRepository<OrderItemEntity, Long> {
    fun findAllByOrderId(orderId: Long): List<OrderItemEntity>

    override fun findBy(id: Long): OrderItem? {
        return findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun findByOrderId(orderId: Long): List<OrderItem> {
        return findAllByOrderId(orderId).map { it.toDomain() }
    }

    override fun save(orderItem: OrderItem): OrderItem {
        val entity = OrderItemEntity.fromDomain(orderItem)
        return save(entity).toDomain()
    }
}
