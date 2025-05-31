package com.dt.ecommerce.domain.customer

data class Customer(
    var id: Long? = null,
    val email: String,
    val name: String,
) {
    companion object {
        fun create(
            email: String,
            name: String
        ) = Customer(
            email = email,
            name = name,
        )
    }
}