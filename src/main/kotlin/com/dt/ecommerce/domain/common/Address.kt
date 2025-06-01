package com.dt.ecommerce.domain.common

data class Address(
    val fullName: String,
    val line1: String,
    val detail: String? = null,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val phoneNumber: String
) {
    companion object {
        val NONE = Address(
            fullName = "",
            line1 = "",
            city = "",
            state = "",
            postalCode = "",
            country = "",
            phoneNumber = ""
        )
    }
}
