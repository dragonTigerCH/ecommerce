package com.dt.ecommerce.infra.order.item

import com.dt.ecommerce.infra.order.item.OrderItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemJpaRepository: JpaRepository<OrderItemEntity, Long>
