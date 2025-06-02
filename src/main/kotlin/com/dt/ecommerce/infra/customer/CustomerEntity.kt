package com.dt.ecommerce.infra.customer

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CustomerEntity(
    email: String,
    name: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "email")
    var email: String = email
        protected set

    @Column(name = "name")
    var name: String = name
        protected set


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
                email = customer.email,
                name = customer.name
            ).run { this.id = customer.pk.getOriginal(); this }
        }
    }
}