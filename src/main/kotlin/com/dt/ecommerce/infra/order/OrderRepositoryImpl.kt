package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.domain.customer.CustomerRepository
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderRepository
import com.dt.ecommerce.infra.customer.CustomerJpaRepository
import com.dt.ecommerce.infra.order.item.OrderItemJpaRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl(
    private val orderRepository: OrderJpaRepository,
    private val orderItemRepository: OrderItemJpaRepository,
): OrderRepository{

    override fun findBy(pk: PK): Order? {
        val items = orderItemRepository.findAllByOrderId(pk.getKey())
        return orderRepository.findById(pk.getKey()).map { it.toDomain() }.orElse(null)
            .copy(items = items.map { it.toDomain() })
    }

    override fun save(order: Order): Order {
        return OrderEntity.fromDomain(order)
            .run { orderRepository.save(this).toDomain() }
    }
}
