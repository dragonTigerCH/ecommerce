package com.dt.ecommerce.infra.customer

import com.dt.ecommerce.domain.common.PK
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
            pk = PK.from(id),
            email = email,
            name = name
        )
    }

    companion object {
        fun fromDomain(customer: Customer): CustomerEntity {
            return CustomerEntity(
                id = customer.pk.getOriginal(),
                email = customer.email,
                name = customer.name
            )
        }
    }
}