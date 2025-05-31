package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.order.OrderItem
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
class OrderItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val orderId: Long,
    val productId: Long,
    val productSku: String,
    val productName: String,
    val quantity: Int,
    val unitPrice: BigDecimal,
    val discount: BigDecimal = BigDecimal.ZERO,
    val subtotal: BigDecimal,

    @ElementCollection
    @CollectionTable(name = "order_item_attributes", joinColumns = [JoinColumn(name = "order_item_id")])
    @MapKeyColumn(name = "attribute_key")
    @Column(name = "attribute_value")
    val attributes: Map<String, String> = emptyMap(),

    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain(): OrderItem {
        return OrderItem(
            id = id,
            orderId = orderId,
            productId = productId,
            productSku = productSku,
            productName = productName,
            quantity = quantity,
            unitPrice = unitPrice,
            discount = discount,
            subtotal = subtotal,
            attributes = attributes,
            createdAt = createdAt
        )
    }

    companion object {
        fun fromDomain(orderItem: OrderItem): OrderItemEntity {
            return OrderItemEntity(
                id = orderItem.id,
                orderId = orderItem.orderId,
                productId = orderItem.productId,
                productSku = orderItem.productSku,
                productName = orderItem.productName,
                quantity = orderItem.quantity,
                unitPrice = orderItem.unitPrice,
                discount = orderItem.discount,
                subtotal = orderItem.subtotal,
                attributes = orderItem.attributes,
                createdAt = orderItem.createdAt
            )
        }
    }
}
