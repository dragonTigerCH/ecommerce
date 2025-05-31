package com.dt.ecommerce.infra

import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.domain.customer.CustomerRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

interface CustomerJpaRepository : CustomerRepository, JpaRepository<CustomerEntity, Long> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.email = :email")
    fun findEntityByEmail(email: String): CustomerEntity?

    override fun findBy(id: Long): Customer? {
        return findById(id).map { it.toDomain() }.orElse(null)
    }

    override fun findByEmail(email: String): Customer? {
        return findEntityByEmail(email)?.toDomain()
    }

    override fun save(customer: Customer): Customer {
        val entity = CustomerEntity.fromDomain(customer)
        return save(entity).toDomain()
    }
}