package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderJpaRepository: OrderRepository, JpaRepository<OrderEntity, Long> {

    override fun findBy(id: Long): Order? {
        return findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun save(order: Order): Order {
        val entity = OrderEntity.fromDomain(order)
        return save(entity).toDomain()
    }
}
