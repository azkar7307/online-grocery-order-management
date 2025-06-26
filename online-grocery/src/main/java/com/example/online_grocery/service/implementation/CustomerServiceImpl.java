package com.example.online_grocery.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_grocery.model.Customer;
import com.example.online_grocery.repository.CustomerRepository;
import com.example.online_grocery.service.CustomerService;
import com.example.online_grocery.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
  
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Customer getCustomerById(Long id) {
    return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public Customer updateCustomer(Long id, Customer customerDetails) {
    Customer existingCustomer = getCustomerById(id);
    existingCustomer.setName(customerDetails.getName());
    existingCustomer.setEmail(customerDetails.getEmail());
    existingCustomer.setAddress(customerDetails.getAddress());
    existingCustomer.setPhone(customerDetails.getPhone());
    return customerRepository.save(existingCustomer);
  }

  @Override
  public void deleteCustomer(Long id) {
    Customer existingCustomer = getCustomerById(id);
    customerRepository.delete(existingCustomer);
  }
  
}
