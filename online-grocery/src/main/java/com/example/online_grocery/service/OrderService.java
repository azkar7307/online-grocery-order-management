package com.example.online_grocery.service;

import java.util.List;

import com.example.online_grocery.dto.OrderRequest;
import com.example.online_grocery.model.Order;

public interface OrderService {
  List<Order> getAllOrders();
  Order getOrderById(Long id);
  Order createOrder(OrderRequest orderRequest);
  void deleteOrder(Long id);
}
