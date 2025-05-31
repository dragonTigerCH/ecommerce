package com.dt.ecommerce.domain.order


interface OrderRepository {
    fun findBy(id: Long): Order?

    fun save(order: Order): Order
}

