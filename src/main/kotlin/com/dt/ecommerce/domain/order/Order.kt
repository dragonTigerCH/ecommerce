package com.dt.ecommerce.domain.order

import com.dt.ecommerce.domain.common.Address
import com.dt.ecommerce.domain.common.Audit
import com.dt.ecommerce.domain.common.AuditInfo
import com.dt.ecommerce.domain.common.Money
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.infra.order.OrderEntity
import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    val pk: PK = PK.NULL,
    val customer: PK,

    val items: List<OrderItem>,
    val status: OrderStatus = OrderStatus.PENDING,

    val totalAmount: Money,
    val shippingAddress: Address,

    val audit: Audit,
    val notes: String? = null,
) {

    /**
     * PENDING: 주문은 생성되었지만 아직 사용자의 결제 시도조차 시작되지 않은 상태.
     * PROCESSING: 결제 요청이 이루어졌으며, 승인/응답을 기다리는 중.
     * PAID: 결제가 완료된 상태.
     * SHIPPED: 배송이 시작됨.
     * DELIVERED: 배송이 완료됨.
     * CANCELLED: 결제 전 또는 처리 중 사용자가 주문을 취소함.
     * REFUNDED: 결제가 완료된 이후 환불된 상태.
     *
     * [*] -> PENDING -> PROCESSING -> PAID
     * [*] -> PENDING -> CANCELLED
     * [*] -> PROCESSING -> CANCELLED
     * [*] -> PAID -> DELIVERED
     * [*] -> PAID -> REFUND
     * [*] -> PAID -> CANCELLED
     * [*] -> SHIPPED -> DELIVERED
     * [*] -> SHIPPED -> CANCELLED
     * [*] -> DELIVERED -> CANCELLED
     * [*] -> REFUNDED -> CANCELLED
     *
     */
    enum class OrderStatus {
        PENDING, PROCESSING, PAID, SHIPPED, DELIVERED, CANCELLED, REFUNDED
    }

    fun processing(updatedBy: PK) = this.copy(
        status = OrderStatus.PROCESSING,
        audit = Audit.updated(this.audit.created, AuditInfo(updatedBy))
    )

    fun paid(updatedBy: PK) = this.copy(
        status = OrderStatus.PAID,
        audit = Audit.updated(this.audit.created, AuditInfo(updatedBy))
    )

    fun shipped(updatedBy: PK) = this.copy(
        status = OrderStatus.SHIPPED,
        audit = Audit.updated(this.audit.created, AuditInfo(updatedBy))
    )

    fun delivered(updatedBy: PK) = this.copy(
        status = OrderStatus.DELIVERED,
        audit = Audit.updated(this.audit.created, AuditInfo(updatedBy))
    )

    fun cancel(updatedBy: PK) = this.copy(
        status = OrderStatus.CANCELLED,
        audit = Audit.updated(this.audit.created, AuditInfo(updatedBy))
    )

    fun refund(updatedBy: PK) = this.copy(
        status = OrderStatus.REFUNDED,
        audit = Audit.updated(this.audit.created, AuditInfo(updatedBy))
    )


    companion object {
        fun create(
            items: List<OrderItem>,
            customer: PK,
            totalAmount: Money,
            shippingAddress: Address = Address.NONE,
        ) = Order(
            items = items,
            customer = customer,
            totalAmount = totalAmount,
            shippingAddress = shippingAddress,
            audit = Audit.from(AuditInfo.from())
        )
    }
}


data class OrderItem(
    val pk: PK = PK.NULL,
    val product: PK,

    val order: Order,

    val name: String,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val audit: Audit,
)