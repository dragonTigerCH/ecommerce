package com.dt.ecommerce.infra.cart

import com.dt.ecommerce.infra.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CartEntity(
    customerId: Long,
): BaseEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "customer_id")
    var customerId: Long = customerId
        protected set
}

class CartItemEntity(

): BaseEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var productId: String? = null
        protected set
    var quantity: Int? = null
        protected set
}