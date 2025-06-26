package com.example.online_grocery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "grocery_items")
@Data
public class GroceryItem {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "item_name")
  private String name;
  private String category;
  private double price;
  private int quantity;
}
