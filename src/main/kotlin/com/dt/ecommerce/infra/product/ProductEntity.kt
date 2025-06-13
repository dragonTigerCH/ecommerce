package com.dt.ecommerce.infra.product

import com.dt.ecommerce.infra.common.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.Cascade

@Entity
@Table(name = "products")
class ProductEntity(
    name: String,
    description: String?,
    price: Double,
    stock: StockEntity
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String = name

    @Column(name = "description")
    var description: String? = description

    @Column(name = "price", nullable = false)
    var price: Double = price

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", nullable = false)
    var stock: StockEntity = stock
}

@Entity
@Table(name = "product_categories")
class ProductCategoryEntity(
    product: ProductEntity,
    category: CategoryEntity,
    isMain: Boolean = false
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    var product: ProductEntity = product

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    var category: CategoryEntity = category

    @Column(name = "is_main", nullable = false)
    var isMain: Boolean = isMain
}

@Entity
@Table(name = "categories")
class CategoryEntity(
    name: String
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String = name
}

@Entity
@Table(name = "stocks")
class StockEntity(
    product: ProductEntity,
    quantity: Int
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @OneToOne(mappedBy = "stock", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false)
    var product: ProductEntity = product

    @Column(name = "quantity", nullable = false)
    var quantity: Int = quantity
}