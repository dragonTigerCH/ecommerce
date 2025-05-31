package com.dt.ecommerce.domain.customer

interface CustomerRepository {
    fun findBy(id: Long): Customer?
    fun findByEmail(email: String): Customer?
    fun save(customer: Customer): Customer
}