package com.dt.ecommerce.infra.order.item

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.item.OrderItem
import com.dt.ecommerce.infra.order.OrderEntity
import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapKeyColumn
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

    @ElementCollection
    @CollectionTable(name = "order_item_attributes", joinColumns = [JoinColumn(name = "order_item_id")])
    @MapKeyColumn(name = "attribute_key")
    @Column(name = "attribute_value")
    val attributes: Map<String, String> = emptyMap(),

    val createdAt: LocalDateTime = LocalDateTime.now()
) {
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
            attributes = attributes,
            createdAt = createdAt
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
                attributes = orderItem.attributes,
                createdAt = orderItem.createdAt
            )
        }
    }
}