package com.dt.ecommerce.app.usecase

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.common.Params
import com.dt.ecommerce.domain.common.UseCase
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderManagement
import com.dt.ecommerce.domain.order.OrderProvider
import org.springframework.stereotype.Component

@Component
class PlaceOrderUseCase(
    private val management: OrderManagement,
    private val provider: OrderProvider,

    ): UseCase<PlaceOrderUseCase.Param, PlaceOrderUseCase.Result> {

    data class Param(
        val productId: Long,
    ): Params {
        override fun validate(): Boolean {

            return true
        }
    }

    class Result(
        val order: Order
    )

    override fun execute(param: Param): Result {
        val load = provider.load(PK.of(1L)) ?: throw Exception()
        TODO()
    }
}