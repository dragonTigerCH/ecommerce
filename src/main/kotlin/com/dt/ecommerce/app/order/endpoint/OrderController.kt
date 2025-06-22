package com.dt.ecommerce.app.order.endpoint

import com.dt.ecommerce.app.order.endpoint.dto.OrderRequest
import com.dt.ecommerce.app.order.endpoint.dto.OrderResponse
import com.dt.ecommerce.app.order.usecase.PlaceOrderUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    private val placeOrderUseCase: PlaceOrderUseCase,
) {
    @PostMapping
    fun place(
        @RequestBody request: OrderRequest
    ): OrderResponse {
        val param = PlaceOrderUseCase.Param(

        )

        return placeOrderUseCase.execute(param)
            .run { OrderResponse.from(this.order) }
    }
}

