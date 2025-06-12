package com.dt.ecommerce.infra.cart

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.infra.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CartEntity(
    customer: Long,
): BaseEntity() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "customer_id", nullable = false)
    var customer: Long = customer
        protected set
}

class CartItemEntity(
    product: Long,
    quantity: Int
): BaseEntity() {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "product_id", nullable = false)
    var product: Long = product
        protected set
    @Column(name = "quantity", nullable = false)
    var quantity: Int = quantity
        protected set
}