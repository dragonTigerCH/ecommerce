package com.dt.ecommerce.infra.order.item

import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemJpaRepository : JpaRepository<OrderItemEntity, Long> {
    fun findAllByOrderId(key: Long): List<OrderItemEntity>
}
