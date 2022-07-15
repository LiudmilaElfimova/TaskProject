package com.liudmila.spring.spring_boot_task.model;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long  id;
    @Column(unique = true, updatable = false)
    private  String сustomerName;
}
