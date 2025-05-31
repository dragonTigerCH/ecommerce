package com.dt.ecommerce

import com.dt.ecommerce.domain.order.OrderProvider
import com.dt.ecommerce.domain.order.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.Test

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest(
    @Autowired private val repository: OrderRepository,
    @Autowired private val provider: OrderProvider,
) {

    @Test
    fun `should place order`(){

        //GIVEN
        println("$repository <<<< ")
        println("$provider <<<< ")
        //WHEN

        //THEN
    }
}