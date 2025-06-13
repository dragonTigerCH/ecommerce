package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.common.Address
import com.dt.ecommerce.domain.common.Audit
import com.dt.ecommerce.domain.common.AuditInfo
import com.dt.ecommerce.domain.common.Money
import com.dt.ecommerce.domain.common.PK
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class OrderTest {

    @Test
    fun `should create order`(){

        //GIVENd
        val items = listOf<OrderItem>()
        val customer = PK.of(1L)
        val address = Address.NONE
        val money = Money()
        val audit = Audit.from(AuditInfo.from())

        val order = Order.create(
            items = items,
            customer = PK.of(1L),
            totalAmount = Money(),
            shippingAddress = Address.NONE
        )
        //WHEN && THEN
        Assertions.assertThat(order.items.size).isEqualTo(items.size)
        Assertions.assertThat(order.status).isEqualTo(Order.OrderStatus.PENDING)
        Assertions.assertThat(order.customer.getKey()).isEqualTo(customer.getKey())
        Assertions.assertThat(order.totalAmount.amount).isEqualTo(money.amount)
        Assertions.assertThat(order.totalAmount.currency).isEqualTo(money.currency)
        Assertions.assertThat(order.shippingAddress.street).isEqualTo(address.street)
        Assertions.assertThat(order.shippingAddress.city).isEqualTo(address.city)
        Assertions.assertThat(order.audit.created.at).isNotNull()
        Assertions.assertThat(order.audit.created.by).isEqualTo(audit.created.by)
        Assertions.assertThat(order.audit.updated.at).isNull()
        Assertions.assertThat(order.audit.updated.by).isEqualTo(audit.updated.by)
    }

}