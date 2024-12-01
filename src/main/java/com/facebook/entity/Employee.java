package com.facebook.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Emp")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double salary;
    private String location;
}
