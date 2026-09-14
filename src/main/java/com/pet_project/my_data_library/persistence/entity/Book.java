package com.pet_project.my_data_library.persistence.entity;


import jakarta.persistence.Entity;
@Entity
public class Book extends BaseEntity {
    private int pages;
    private String author;
}
