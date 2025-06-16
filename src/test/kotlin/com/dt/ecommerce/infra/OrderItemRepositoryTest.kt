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
    fun `should return empty order items`(){

        //GIVEN && WHEN
        val items = repository.findAllByOrderId(NON_EXISTENT_ORDER_ID)

        //THEN
        assertThat(items).isEmpty()
    }

    companion object {
        private const val NON_EXISTENT_ORDER_ID = 0L
    }
}
