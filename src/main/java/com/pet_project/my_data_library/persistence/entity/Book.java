package com.pet_project.my_data_library.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private  long id;
    private String title;
    private String author;
    private String publisher;

}
