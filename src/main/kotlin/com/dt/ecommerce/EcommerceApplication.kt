package com.dt.ecommerce

import com.dt.ecommerce.infra.user.UserJpaRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EcommerceApplication

fun main(args: Array<String>) {
    val app = runApplication<EcommerceApplication>(*args)

    // ApplicationContext에서 UserRepository 빈을 가져옵니다
    val userJpaRepository = app.getBean(UserJpaRepository::class.java)

    println(userJpaRepository)
}