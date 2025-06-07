package com.dt.ecommerce.app.order.endpoint.dto

import com.dt.ecommerce.domain.order.Order

class OrderResponse(

) {
    companion object {
        fun from(order: Order): OrderResponse {
            println(order)
            return OrderResponse()
        }
    }
}