package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.order.Address
import jakarta.persistence.Embeddable

@Embeddable
class AddressEntity(
    val fullName: String,
    val line1: String,
    val detail: String? = null,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val phoneNumber: String
) {
    fun toDomain(): Address {
        return Address(
            fullName = fullName,
            line1 = line1,
            detail = detail,
            city = city,
            state = state,
            postalCode = postalCode,
            country = country,
            phoneNumber = phoneNumber
        )
    }

    companion object {
        fun fromDomain(address: Address): AddressEntity {
            return AddressEntity(
                fullName = address.fullName,
                line1 = address.line1,
                detail = address.detail,
                city = address.city,
                state = address.state,
                postalCode = address.postalCode,
                country = address.country,
                phoneNumber = address.phoneNumber
            )
        }

        val NONE = fromDomain(Address.NONE)
    }
}