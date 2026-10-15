package com.pet_project.my_data_library.service;


import com.pet_project.my_data_library.persistence.entity.Book;
import com.pet_project.my_data_library.persistence.repository.BookRepository;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode
@Service
@Validated
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(@Valid Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}




