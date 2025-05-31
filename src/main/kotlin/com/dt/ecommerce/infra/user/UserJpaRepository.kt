package com.dt.ecommerce.infra.user

import com.dt.ecommerce.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository: JpaRepository<User, Long> {
}