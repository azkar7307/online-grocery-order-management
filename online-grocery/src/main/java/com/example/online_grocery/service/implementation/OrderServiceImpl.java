package com.example.online_grocery.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_grocery.dto.OrderRequest;
import com.example.online_grocery.exception.ResourceNotFoundException;
import com.example.online_grocery.model.Customer;
import com.example.online_grocery.model.GroceryItem;
import com.example.online_grocery.model.Order;
import com.example.online_grocery.repository.CustomerRepository;
import com.example.online_grocery.repository.GroceryItemRepository;
import com.example.online_grocery.repository.OrderRepository;
import com.example.online_grocery.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
  
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private GroceryItemRepository groceryItemRepository;

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Order getOrderById(Long id) {
    return orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
  }

  @Override
  public Order createOrder(OrderRequest orderRequest) {
    Customer customer = customerRepository.findById(orderRequest.getCustomerId())
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomerId()));
    List<GroceryItem> groceryItems = groceryItemRepository.findAllById(orderRequest.getGroceryItemIds());

    if (groceryItems.size() != orderRequest.getGroceryItemIds().size()) {
      throw new ResourceNotFoundException("One or more grocery items not found");
    }
    Order order = new Order();
    order.setCustomer(customer);
    order.setOrderItems(groceryItems);
    order.setOrderDate(LocalDateTime.now());
    order.setTotalAmount(groceryItems.stream().mapToDouble((item) -> item.getPrice() * item.getQuantity()).sum());
    return orderRepository.save(order);
  }

  @Override
  public void deleteOrder(Long id) {
    Order existingOrder = getOrderById(id);
    orderRepository.delete(existingOrder);    
  }


  
}
