package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.common.PK
import org.springframework.stereotype.Service

interface OrderProvider {
    fun load(key: PK): Order?
}