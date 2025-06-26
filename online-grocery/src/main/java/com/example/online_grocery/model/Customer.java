package com.example.online_grocery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String email;
  private String address;
  private String phone;
}
