package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.common.Address
import jakarta.persistence.Embeddable

@Embeddable
class AddressEntity(
    val fullName: String,
    val street: String,
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
            street = street,
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
                street = address.street,
                detail = address.detail,
                city = address.city,
                state = address.state,
                postalCode = address.postalCode,
                country = address.country,

                fullName = address.fullName,
                phoneNumber = address.phoneNumber
            )
        }

        val NONE = fromDomain(Address.NONE)
    }
}