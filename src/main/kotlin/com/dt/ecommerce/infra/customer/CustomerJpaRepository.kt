package com.dt.ecommerce.infra.customer

import org.springframework.data.jpa.repository.JpaRepository

interface CustomerJpaRepository: JpaRepository<CustomerEntity, Long>