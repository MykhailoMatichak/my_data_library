package com.pet_project.my_data_library.persistence.entity;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@ToString
public class Manga extends BaseEntity {
    private String author;
}
