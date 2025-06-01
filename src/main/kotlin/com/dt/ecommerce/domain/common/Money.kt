package com.dt.ecommerce.domain.common

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal = BigDecimal.ZERO,
    val currency: String = "KRW"
)
