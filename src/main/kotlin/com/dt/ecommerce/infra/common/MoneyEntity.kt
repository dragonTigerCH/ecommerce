package com.dt.ecommerce.infra.common

import com.dt.ecommerce.domain.common.Money
import jakarta.persistence.Embeddable
import java.math.BigDecimal


@Embeddable
class MoneyEntity(
    val amount: BigDecimal = BigDecimal.ZERO,
    val currency: String = "KRW"
) {
    fun toDomain(): Money {
        return Money(
            amount = amount,
            currency = currency
        )
    }

    companion object {
        fun fromDomain(money: Money): MoneyEntity {
            return MoneyEntity(
                amount = money.amount,
                currency = money.currency
            )
        }
    }
}