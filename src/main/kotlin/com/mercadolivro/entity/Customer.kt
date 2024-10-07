package com.mercadolivro.entity

data class Customer (
    val id: Int,
    val name: String,
    val email: String
) {
    companion object {
        var id = 1
    }
}