package com.dt.ecommerce.infra.customer

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.domain.customer.CustomerRepository
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryImpl(
    private val jpaRepository: CustomerJpaRepository
): CustomerRepository {
    override fun findBy(pk: PK): Customer? {
        return jpaRepository.findById(pk.getKey()).map { it.toDomain() }.orElse(null)
    }

    override fun save(customer: Customer): Customer {
        return jpaRepository.save(CustomerEntity.fromDomain(customer)).toDomain()
    }

}