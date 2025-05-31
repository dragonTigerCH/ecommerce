package com.dt.ecommerce.infra

import com.dt.ecommerce.domain.customer.Customer
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val email: String,
    val name: String,
) {
    fun toDomain(): Customer {
        return Customer(
            id = id,
            email = email,
            name = name
        )
    }

    companion object {
        fun fromDomain(customer: Customer): CustomerEntity {
            return CustomerEntity(
                id = customer.id,
                email = customer.email,
                name = customer.name
            )
        }
    }
}