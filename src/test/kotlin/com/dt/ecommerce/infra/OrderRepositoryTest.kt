package com.dt.ecommerce.infra

import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.OrderProvider
import com.dt.ecommerce.domain.order.OrderRepository
import com.dt.ecommerce.infra.common.AddressEntity
import com.dt.ecommerce.infra.common.MoneyEntity
import com.dt.ecommerce.infra.order.OrderEntity
import com.dt.ecommerce.infra.order.OrderJpaRepository
import org.assertj.core.api.Assertions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.Test

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest(
    @Autowired private val repository: OrderJpaRepository,
) {

    @Test
    fun `should place order`(){

        //GIVEN
        val entity = OrderEntity(
            customer = 1L,
            shippingAddress = AddressEntity("", "", "", "", "", "", "", ""),
            totalAmount = MoneyEntity(),
            status = Order.OrderStatus.PENDING,
            notes = null
        )
        //WHEN
        val stored = repository.save(entity)

        //THEN
        Assertions.assertThat(stored).isEqualTo(entity)
    }
}