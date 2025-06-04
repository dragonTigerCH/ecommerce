package com.dt.ecommerce.infra.order.item

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.OrderItem
import com.dt.ecommerce.infra.BaseEntity
import com.dt.ecommerce.infra.order.OrderEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
class OrderItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val order: OrderEntity,
    val productId: Long,
    val productSku: String,
    val productName: String,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val discount: BigDecimal = BigDecimal.ZERO,
    val subtotal: BigDecimal,
): BaseEntity() {
    fun toDomain(): OrderItem {
        return OrderItem(
            pk = PK.from(id),
            order = order.toDomain(),
            productId = productId,
            productSku = productSku,
            productName = productName,
            quantity = quantity,
            unitPrice = unitPrice,
            discount = discount,
            subtotal = subtotal,
        )
    }

    companion object {
        fun fromDomain(orderItem: OrderItem): OrderItemEntity {
            return OrderItemEntity(
                id = orderItem.pk.getOriginal(),
                order = OrderEntity.fromDomain(orderItem.order),
                productId = orderItem.productId,
                productSku = orderItem.productSku,
                productName = orderItem.productName,
                quantity = orderItem.quantity,
                unitPrice = orderItem.unitPrice,
                discount = orderItem.discount,
                subtotal = orderItem.subtotal,
            )
        }
    }
}