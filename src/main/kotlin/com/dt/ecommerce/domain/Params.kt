package com.dt.ecommerce.domain

interface Params {
    fun validate(): Boolean
}

interface UseCase<Params, R> {
    fun execute(param: Params): R
}
