package com.pet_project.my_data_library.console;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.ColumnData;
import com.pet_project.my_data_library.persistence.entity.Book;
import com.pet_project.my_data_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ConsoleMenu implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        //ASCII table output
        List<Book> books = bookService.getAllBooks();
        System.out.println(AsciiTable.getTable(
                AsciiTable.FANCY_ASCII,
                books,
                Arrays.asList(
                        new Column().header("Id").with(book -> String.valueOf(book.getId()).substring(0, 8)),
                        new Column().header("Name").with(book -> book.getName()),
                        new Column().header("Author").with(book -> book.getAuthor()),
                        new Column().header("Release year").with(book -> String.valueOf(book.getReleaseYear())),
                        new Column().header("Pages").with(book -> String.valueOf(book.getPages())),
                        new Column().header("Create date").with(book -> String.valueOf(book.getPages())),
                        new Column().header("Comment").with(book -> book.getComment())

                )
        ));
        //ASCII
    }

}
