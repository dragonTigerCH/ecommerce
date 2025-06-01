package com.dt.ecommerce.domain.common


typealias PK = PrimaryKey
data class PrimaryKey(
    val value: Long? = null
) {
    fun isNull(): Boolean = this.value == null

    fun getKey(): Long = this.value ?: throw IllegalStateException("PrimaryKey is null")
    fun getOriginal(): Long? = this.value


    companion object {
        val NULL = PrimaryKey(null)
        fun of(value: Long): PrimaryKey = PrimaryKey(value)
        fun from(value: Long?) = PrimaryKey(value)
    }
}