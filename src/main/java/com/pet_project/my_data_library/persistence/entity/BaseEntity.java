package com.pet_project.my_data_library.persistence.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;
     @CreationTimestamp
     private LocalDateTime createdDate;
     private String name;
     private int releaseYear;
     private String comment;

}
