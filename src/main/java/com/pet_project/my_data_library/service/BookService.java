package com.pet_project.my_data_library.service;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.pet_project.my_data_library.persistence.entity.Book;
import com.pet_project.my_data_library.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}




