package com.pet_project.my_data_library.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     private LocalDateTime createdDate;
     private String name;


}
