package com.dt.ecommerce.infra.product

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class ProductEntity(
    name: String,
    price: Double,
    quantity: Int
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @Column(name = "name", nullable = false)
    var name: String = name
    @Column(name = "description")
    var description: String? = null
    @Column(name = "price", nullable = false)
    var price: Double = price
    @Column(name = "quantity", nullable = false)
    var quantity: Int = quantity

}