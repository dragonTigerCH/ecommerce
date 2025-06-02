package com.dt.ecommerce.infra.cart

import org.springframework.data.jpa.repository.JpaRepository

interface CartJpaRepository : JpaRepository<CartEntity, Long>