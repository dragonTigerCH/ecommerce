package com.dt.ecommerce.infra.cart

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CartEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    ) {
}