package com.mercadolivro.controller

import com.mercadolivro.dto.CustomerRequest
import com.mercadolivro.entity.Customer
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/customer")
class CustomerController (
   private val service: CustomerService) {


    @GetMapping("/customers")
    fun getAll(@RequestParam name: String?): List<Customer> {
        return service.getAll(name)
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: CustomerRequest) {
        service.createCustomer(customer)
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getCustomerById(@PathVariable id: Int): Customer {
        return service.getCustomerById(id)
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: CustomerRequest) {
        service.update(id, customer)
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        service.delete(id)
    }
}
