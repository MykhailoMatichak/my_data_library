package com.pet_project.my_data_library.service;

import com.pet_project.my_data_library.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

}
