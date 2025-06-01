package com.dt.ecommerce.infra.order

import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository: JpaRepository<OrderEntity, Long>