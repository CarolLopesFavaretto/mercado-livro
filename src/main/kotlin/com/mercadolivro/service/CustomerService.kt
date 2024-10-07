package com.mercadolivro.service

import com.mercadolivro.dto.CustomerRequest
import com.mercadolivro.entity.Customer
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService {

    val customers = mutableListOf<Customer>()

    fun getAll(name: String?): List<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name, ignoreCase = true) }
        }
        return customers
    }

    fun createCustomer(customer: CustomerRequest) {
        val id = if (customers.isEmpty()){
            1
        } else {
            customers.last().id + 1
        }
        customers.add(Customer(id, customer.name, customer.email))
    }

    fun getCustomerById(id: Int): Customer {
        return customers.filter { it.id == id }.first()
    }


}