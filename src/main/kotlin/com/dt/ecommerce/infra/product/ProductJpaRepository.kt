package com.dt.ecommerce.infra.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository: JpaRepository<ProductEntity, Long>