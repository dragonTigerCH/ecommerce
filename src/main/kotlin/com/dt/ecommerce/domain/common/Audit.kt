package com.dt.ecommerce.domain.common

import java.time.LocalDateTime

data class Audit(
    val created: AuditInfo,
    val updated: AuditInfo = AuditInfo.NONE,
) {
    companion object {
        fun from(created: AuditInfo) = Audit(created)
    }
}

data class AuditInfo(
    val by: PK,
    val at: LocalDateTime? = null,
) {
    companion object {
        val NONE = AuditInfo(
            by = PK.NULL,
            at = null
        )

        fun from() = AuditInfo(
            by = PK.NULL,
            at = LocalDateTime.now()
        )
        fun from(by: Long?) = AuditInfo(
            by = PK.from(by),
            at = LocalDateTime.now()
        )
    }
}