package com.pet_project.my_data_library.console;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.pet_project.my_data_library.persistence.entity.Book;
import com.pet_project.my_data_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@Component
public class ConsoleMenu implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> booksMenu();
                case 2 -> System.out.println("TODO: фільми");
                case 3 -> System.out.println("TODO: манга");
                case 0 -> running = false;
                default -> System.out.println("Невірний вибір, спробуй ще раз.");
            }
        }
    }

    private void printBooksTable() {
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
                        new Column().header("Create date").with(book -> String.valueOf(book.getCreatedDate()).substring(0, 10)),
                        new Column().header("Comment").with(book -> book.getComment())

                )
        ));
    }

    private void printMainMenu() {
        System.out.println("""
                === Головне меню ===
                1. Книги
                2. Фільми
                3. Манга
                0. Вийти
                """);
    }

    private void booksMenu() {
        boolean inSubMenu = true;
        while (inSubMenu) {
            System.out.println("""
                    -- Книги --
                    1. Показати всі
                    2. Додати
                    3. Видалити
                    0. Назад
                    """);
            int choice = readInt();
            switch (choice) {
                case 1 -> printBooksTable(); // той метод з ASCII-таблицею, що ти вже написав
                case 2 -> { /* TODO: сам напиши */ }
                case 3 -> { /* TODO: сам напиши */ }
                case 0 -> inSubMenu = false;
                default -> System.out.println("Невірний вибір.");
            }
        }
    }
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

}
