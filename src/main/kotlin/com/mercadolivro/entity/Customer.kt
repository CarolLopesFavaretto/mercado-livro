package com.mercadolivro.entity

data class Customer (
    val id: Int,
    var name: String,
    var email: String
) {
    companion object {
        var id = 1
    }
}