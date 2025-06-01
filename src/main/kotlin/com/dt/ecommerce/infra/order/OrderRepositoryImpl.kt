package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    private val jpaRepository: OrderJpaRepository
): OrderRepository{

    override fun findBy(id: Long): Order? {
        return jpaRepository.findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun save(order: Order): Order {
        val entity = OrderEntity.fromDomain(order)
        return jpaRepository.save(entity).toDomain()
    }
}
