package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.Order.OrderStatus
import com.dt.ecommerce.infra.customer.CustomerEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val orderDate: LocalDateTime = LocalDateTime.now(),

    @Enumerated(EnumType.STRING)
    val status: OrderStatus = OrderStatus.PENDING,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id")
    val customer: CustomerEntity,

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "fullName", column = Column(name = "shipping_full_name")),
        AttributeOverride(name = "line1", column = Column(name = "shipping_line1")),
        AttributeOverride(name = "detail", column = Column(name = "shipping_detail")),
        AttributeOverride(name = "city", column = Column(name = "shipping_city")),
        AttributeOverride(name = "state", column = Column(name = "shipping_state")),
        AttributeOverride(name = "postalCode", column = Column(name = "shipping_postal_code")),
        AttributeOverride(name = "country", column = Column(name = "shipping_country")),
        AttributeOverride(name = "phoneNumber", column = Column(name = "shipping_phone_number"))
    )
    val shippingAddress: AddressEntity,

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "fullName", column = Column(name = "billing_full_name")),
        AttributeOverride(name = "line1", column = Column(name = "billing_line1")),
        AttributeOverride(name = "detail", column = Column(name = "billing_detail")),
        AttributeOverride(name = "city", column = Column(name = "billing_city")),
        AttributeOverride(name = "state", column = Column(name = "billing_state")),
        AttributeOverride(name = "postalCode", column = Column(name = "billing_postal_code")),
        AttributeOverride(name = "country", column = Column(name = "billing_country")),
        AttributeOverride(name = "phoneNumber", column = Column(name = "billing_phone_number"))
    )
    val billingAddress: AddressEntity,

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "amount", column = Column(name = "total_amount")),
        AttributeOverride(name = "currency", column = Column(name = "total_currency"))
    )
    val totalAmount: MoneyEntity,

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "amount", column = Column(name = "tax_amount")),
        AttributeOverride(name = "currency", column = Column(name = "tax_currency"))
    )
    val tax: MoneyEntity,

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "amount", column = Column(name = "shipping_cost_amount")),
        AttributeOverride(name = "currency", column = Column(name = "shipping_cost_currency"))
    )
    val shippingCost: MoneyEntity,

    val notes: String? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = null
) {
    fun toDomain(): Order {
        return Order(
            pk = PK.from(id),
            items = emptyList(), //TODO
            orderDate = orderDate,
            status = status,
            customer = customer.toDomain(),
            shippingAddress = shippingAddress.toDomain(),
            billingAddress = billingAddress.toDomain(),
            totalAmount = totalAmount.toDomain(),
            tax = tax.toDomain(),
            shippingCost = shippingCost.toDomain(),
            notes = notes,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }

    companion object {
        fun fromDomain(order: Order): OrderEntity {
            return OrderEntity(
                id = order.pk.getOriginal(),
                orderDate = order.orderDate,
                status = order.status,
                customer = CustomerEntity.fromDomain(order.customer),
                shippingAddress = AddressEntity.fromDomain(order.shippingAddress),
                billingAddress = AddressEntity.fromDomain(order.billingAddress),
                totalAmount = MoneyEntity.fromDomain(order.totalAmount),
                tax = MoneyEntity.fromDomain(order.tax),
                shippingCost = MoneyEntity.fromDomain(order.shippingCost),
                notes = order.notes,
                createdAt = order.createdAt,
                updatedAt = order.updatedAt
            )
        }
    }
}
