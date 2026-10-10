package com.pet_project.my_data_library.validation;


import org.springframework.stereotype.Component;

@Component
public class BookValidator {

    public boolean isValidName(String name) {
        if  (name == null || name.isBlank()) {
        }
        return false;
    }
}
