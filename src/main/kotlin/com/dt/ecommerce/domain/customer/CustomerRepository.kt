package com.dt.ecommerce.domain.customer

import com.dt.ecommerce.domain.common.PK

interface CustomerRepository {
    fun findBy(pk: PK): Customer?
    fun save(customer: Customer): Customer
}