package com.dt.ecommerce.infra.customer

import com.dt.ecommerce.domain.common.Audit
import com.dt.ecommerce.domain.common.AuditInfo
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.infra.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "customers")
class CustomerEntity(
    email: String,
    name: String,
): BaseEntity() {

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
            name = name,
            audit = Audit.from(AuditInfo.from())
        )
    }

    companion object {
        fun fromDomain(customer: Customer): CustomerEntity {
            return CustomerEntity(
                email = customer.email,
                name = customer.name
            ).also { it.id = customer.pk.getOriginal() }
        }
    }
}