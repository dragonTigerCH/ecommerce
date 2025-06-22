package com.dt.ecommerce.app.order.usecase

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.common.Params
import com.dt.ecommerce.domain.common.UseCase
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderManagement
import com.dt.ecommerce.domain.order.OrderProvider
import com.dt.ecommerce.domain.product.Product
import com.dt.ecommerce.domain.product.ProductProvider
import org.springframework.stereotype.Component

@Component
class PlaceOrderUseCase(
    private val management: OrderManagement,
    private val provider: OrderProvider,

    private val productProvider: ProductProvider,
    ): UseCase<PlaceOrderUseCase.Param, PlaceOrderUseCase.Result> {

    class Param(

    ): Params {
        override fun validate(): Boolean {

            return true
        }
    }

    class Result(
        val order: Order
    )

    override fun execute(param: Param): Result {
        TODO()
    }
}