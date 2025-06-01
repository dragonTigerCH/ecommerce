package com.dt.ecommerce.infra.customer

import com.dt.ecommerce.domain.customer.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerJpaRepository: JpaRepository<CustomerEntity, Long>