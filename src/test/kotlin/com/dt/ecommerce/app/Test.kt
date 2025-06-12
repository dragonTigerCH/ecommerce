package com.dt.ecommerce.app

import com.dt.ecommerce.domain.common.Address
import com.dt.ecommerce.domain.common.Money
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderItem
import kotlin.test.Test

class Test {

    @Test
    fun `should d`() {

        //GIVEN
        val items = listOf<OrderItem>()
        val customer = PK.of(1L)
        val address = Address.NONE
        val money = Money()

        val order1 = Order.create(
            items = items,
            customer = PK.of(1L),
            totalAmount = Money(),
            shippingAddress = Address.NONE
        )
        val order2 = order1.copy(
            totalAmount = Money()
        )

        println(order1.totalAmount === order2.totalAmount)

        //WHEN

        //THEN }
    }
}