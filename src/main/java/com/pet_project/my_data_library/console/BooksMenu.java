package com.pet_project.my_data_library.console;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.pet_project.my_data_library.persistence.entity.Book;
import com.pet_project.my_data_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BooksMenu {

    @Autowired
    private BookService bookService;

    @Autowired
    private ConsoleReader consoleReader;

    public void menu() {
        boolean inSubMenu = true;
        while (inSubMenu) {
            System.out.println("""
                    -- Книги --
                    1. Показати всі
                    2. Додати
                    3. Видалити
                    0. Назад
                    """);
            int choice = consoleReader.readInt();
            switch (choice) {
                case 1 -> printBooksTable();
                case 2 -> addBook();
                case 3 -> deleteBook();
                case 0 -> inSubMenu = false;
                default -> System.out.println("Невірний вибір.\n");
            }
        }
    }

    public void printBooksTable() {
        List<Book> books = bookService.getAllBooks();
        System.out.println(AsciiTable.getTable(
                AsciiTable.FANCY_ASCII,
                books,
                Arrays.asList(
                        new Column().header("№").with(book -> String.valueOf(books.indexOf(book) + 1)),
                        new Column().header("Name").with(book -> book.getName()),
                        new Column().header("Author").with(book -> book.getAuthor()),
                        new Column().header("Release year").with(book -> String.valueOf(book.getReleaseYear())),
                        new Column().header("Pages").with(book -> String.valueOf(book.getPages())),
                        new Column().header("Create date").with(book -> String.valueOf(book.getCreatedDate()).substring(0, 10)),
                        new Column().header("Comment").with(book -> book.getComment())

                )
        ));
    }

    public void addBook() {
        System.out.print("Задайте назву книги: ");
        String name = consoleReader.readString();

        System.out.print("Задайте автора: ");
        String author = consoleReader.readString();

        System.out.print("Задайте рік випуску: ");
        int releaseYear = consoleReader.readInt();

        System.out.print("Задайте кількість сторінок: ");
        int pages = consoleReader.readInt();

        System.out.print("Бажаєте додати коментар?(y/n): ");
        String answer = consoleReader.readString();
        String comment = null;
        if(answer.equalsIgnoreCase("y")){
            System.out.print("Задайте коментар про книгу: ");
            comment = consoleReader.readString();
        }

        //write to object book
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setReleaseYear(releaseYear);
        book.setPages(pages);
        book.setComment(comment);

        bookService.addBook(book);
    }

    private void deleteBook() {
        List<Book> books = bookService.getAllBooks();
        System.out.print("Введіть №: ");
        int num =  consoleReader.readInt();
        if(num < 1 || num > books.size()) {
            System.out.println("Невірний номер. Всього книг: " + books.size());
            return;
        }
        Book book = books.get(num -1);
        System.out.println("Книгу успішно видалено.");
        bookService.deleteBook(book.getId());
    }
}
