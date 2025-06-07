package com.dt.ecommerce.domain.order

import org.springframework.stereotype.Service

interface OrderManagement {
    fun place(order: Order): Order
}

