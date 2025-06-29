package com.example.online_grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_grocery.model.Customer;
import com.example.online_grocery.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
  @Autowired
  CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
    Customer customer = customerService.getCustomerById(id);
    return ResponseEntity.ok(customer);
  }
  
  @PostMapping
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.createCustomer(customer);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
    Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
    return ResponseEntity.ok(updatedCustomer);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }
}
