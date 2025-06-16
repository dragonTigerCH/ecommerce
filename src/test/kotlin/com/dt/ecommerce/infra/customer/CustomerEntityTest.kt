package com.dt.ecommerce.infra.customer

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.util.UUID
import kotlin.test.Test

@DataJpaTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerEntityTest @Autowired constructor(
    private val repository: CustomerJpaRepository
) {

    @Test
    fun `should`(){

        //GIVEN

        //WHEN

        //THEN
    }
}