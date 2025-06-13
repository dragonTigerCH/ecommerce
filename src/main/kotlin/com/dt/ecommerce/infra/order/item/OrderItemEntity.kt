package com.dt.ecommerce.infra.order.item

import com.dt.ecommerce.domain.common.Audit
import com.dt.ecommerce.domain.common.AuditInfo
import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.OrderItem
import com.dt.ecommerce.infra.common.BaseEntity
import com.dt.ecommerce.infra.order.OrderEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "order_items")
class OrderItemEntity(
    order: OrderEntity,
    product: Long,
    name: String,
    quantity: Int,
    unitPrice: BigDecimal
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @ManyToOne(fetch = FetchType.LAZY)
    var order: OrderEntity = order
    @Column(name = "product_id", nullable = false)
    var product: Long = product
    @Column(name = "name", nullable = false)
    var name: String = name
    @Column(name = "quantity", nullable = false)
    var quantity: Int = quantity
    @Column(name = "unit_price", nullable = false)
    var unitPrice: BigDecimal = unitPrice

    fun toDomain(): OrderItem {
        return OrderItem(
            pk = PK.from(id),
            order = order.toDomain(),
            product = PK.from(product),
            name = name,
            quantity = quantity,
            unitPrice = unitPrice,
            audit = Audit.from(AuditInfo.from(by = createdBy))
        )
    }

    companion object {
        fun fromDomain(orderItem: OrderItem): OrderItemEntity {
            return OrderItemEntity(
                order = OrderEntity.fromDomain(orderItem.order),
                product = orderItem.product.getKey(),
                name = orderItem.name,
                quantity = orderItem.quantity,
                unitPrice = orderItem.unitPrice,
            ).also { it.id = orderItem.pk.getOriginal() }
        }
    }
}