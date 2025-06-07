package com.dt.ecommerce.infra

import com.dt.ecommerce.infra.order.item.OrderItemJpaRepository
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.Test

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderItemRepositoryTest(
    @Autowired private val repository: OrderItemJpaRepository,
) {

    @Test
    fun `should find all order items by order id`(){

        //GIVEN

        val orderId = 1L

        //WHEN
        val items = repository.findAllByOrderId(orderId)

        //THEN
        assertThat(items.size).isEqualTo(0)
    }
}