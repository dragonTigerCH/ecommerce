package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.Order.OrderStatus
import com.dt.ecommerce.domain.order.OrderItem
import com.dt.ecommerce.infra.BaseEntity
import com.dt.ecommerce.infra.common.AddressEntity
import com.dt.ecommerce.infra.common.MoneyEntity
import com.dt.ecommerce.infra.order.item.OrderItemEntity
import jakarta.persistence.*
import org.hibernate.annotations.Cascade

@Entity
@Table(name = "orders")
class OrderEntity(
    customer: Long,
    shippingAddress: AddressEntity,
    totalAmount: MoneyEntity,

    status: OrderStatus,
    notes: String?
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    var status: OrderStatus = status

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    var items: MutableList<OrderItemEntity> = mutableListOf()
        protected set

    @JoinColumn(name = "customer_id")
    var customerId: Long = customer
        protected set

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "fullName", column = Column(name = "shipping_full_name")),
        AttributeOverride(name = "street", column = Column(name = "shipping_street")),
        AttributeOverride(name = "detail", column = Column(name = "shipping_detail")),
        AttributeOverride(name = "city", column = Column(name = "shipping_city")),
        AttributeOverride(name = "state", column = Column(name = "shipping_state")),
        AttributeOverride(name = "postalCode", column = Column(name = "shipping_postal_code")),
        AttributeOverride(name = "country", column = Column(name = "shipping_country")),
        AttributeOverride(name = "phoneNumber", column = Column(name = "shipping_phone_number"))
    )
    var shippingAddress: AddressEntity = shippingAddress

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "amount", column = Column(name = "total_amount")),
        AttributeOverride(name = "currency", column = Column(name = "total_currency"))
    )
    @Column(name = "total_amount", nullable = false)
    var totalAmount: MoneyEntity = totalAmount
        protected set

    @Column(name = "notes")
    var notes: String? = notes
        protected set


    fun toDomain(): Order {
        return Order(
            pk = PK.from(id),
            customer = PK.from(customerId),
            items = items.map { it.toDomain() },
            status = status,
            shippingAddress = shippingAddress.toDomain(),
            totalAmount = totalAmount.toDomain(),
            notes = notes,
            createdAt = createdAt
        )
    }

    companion object {
        fun fromDomain(order: Order): OrderEntity =
            OrderEntity(
                status = order.status,
                customer = order.customer.getKey(),
                shippingAddress = AddressEntity.fromDomain(order.shippingAddress),
                totalAmount = MoneyEntity.fromDomain(order.totalAmount),
                notes = order.notes,
            ).also {
                it.id = order.pk.getOriginal()
            }

    }
}
