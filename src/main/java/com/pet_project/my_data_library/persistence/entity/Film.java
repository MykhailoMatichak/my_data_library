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
public class Film extends BaseEntity {
    private String director;
    private int duration;
}
