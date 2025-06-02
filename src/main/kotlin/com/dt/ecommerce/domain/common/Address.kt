package com.dt.ecommerce.domain.common

data class Address(
    val street: String,
    val detail: String? = null,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,

    // personal
    val fullName: String,
    val phoneNumber: String
) {
    companion object {
        val NONE = Address(
            street = "",
            city = "",
            state = "",
            postalCode = "",
            country = "",

            fullName = "",
            phoneNumber = ""
        )
    }
}
