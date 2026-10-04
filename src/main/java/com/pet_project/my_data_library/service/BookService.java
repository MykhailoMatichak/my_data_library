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
    Scanner scanner = new Scanner(System.in);

    @Autowired
    private BookRepository bookRepository;

    private List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void printBooksTable() {
        List<Book> books = getAllBooks();
        System.out.println(AsciiTable.getTable(
                AsciiTable.FANCY_ASCII,
                books,
                Arrays.asList(
                        new Column().header("Id").with(book -> String.valueOf(book.getId()).substring(0, 8)),
                        new Column().header("Name").with(book -> book.getName()),
                        new Column().header("Author").with(book -> book.getAuthor()),
                        new Column().header("Release year").with(book -> String.valueOf(book.getReleaseYear())),
                        new Column().header("Pages").with(book -> String.valueOf(book.getPages())),
                        new Column().header("Create date").with(book -> String.valueOf(book.getCreatedDate()).substring(0, 10)),
                        new Column().header("Comment").with(book -> book.getComment())

                )
        ));
    }

    public Book addBook(Book book) {

        if(book.getName() == null){

        }


        return bookRepository.save(book);
    }

}




