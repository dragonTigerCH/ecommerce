package com.dt.ecommerce.domain.customer

import com.dt.ecommerce.domain.common.Audit
import com.dt.ecommerce.domain.common.AuditInfo
import com.dt.ecommerce.domain.common.PK

data class Customer(
    val pk: PK = PK.NULL,
    val email: String,
    val name: String,

    val audit: Audit,
) {
    companion object {
        fun create(
            email: String,
            name: String
        ) = Customer(
            email = email,
            name = name,
            audit = Audit.from(AuditInfo.from())
        )
    }
}