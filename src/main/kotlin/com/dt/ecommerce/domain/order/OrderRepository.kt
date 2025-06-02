package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer


interface OrderRepository {
    fun findBy(pk: PK): Order?

    fun save(order: Order, customer: Customer): Order
}

