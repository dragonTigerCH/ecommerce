package com.dt.ecommerce.infra.order

import com.dt.ecommerce.domain.common.PK
import com.dt.ecommerce.domain.customer.Customer
import com.dt.ecommerce.domain.order.Order
import com.dt.ecommerce.domain.order.Order.OrderStatus
import com.dt.ecommerce.infra.customer.CustomerEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class OrderEntity(

    customer: CustomerEntity,
    shippingAddress: AddressEntity,
    totalAmount: MoneyEntity,

    status: OrderStatus = OrderStatus.PENDING,
    notes: String? = null,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    var status: OrderStatus = status

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id")
    var customer: CustomerEntity = customer

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
    var totalAmount: MoneyEntity = totalAmount

    var notes: String? = notes
    var createdAt: LocalDateTime = LocalDateTime.now()
    var updatedAt: LocalDateTime? = null


    fun toDomain(): Order {
        return Order(
            pk = PK.from(id),
            customer = customer.toDomain(),
            items = emptyList(), //TODO
            status = status,
            shippingAddress = shippingAddress.toDomain(),
            totalAmount = totalAmount.toDomain(),
            notes = notes,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }

    companion object {
        fun fromDomain(order: Order, customer: Customer): OrderEntity =
            OrderEntity(
                status = order.status,
                customer = CustomerEntity.fromDomain(customer),
                shippingAddress = AddressEntity.fromDomain(order.shippingAddress),
                totalAmount = MoneyEntity.fromDomain(order.totalAmount),
                notes = order.notes,
            ).run {
                this.id = order.pk.getOriginal();
                this
            }

    }
}
