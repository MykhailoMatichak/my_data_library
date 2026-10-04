package com.pet_project.my_data_library.console;

import com.pet_project.my_data_library.persistence.entity.Book;
import com.pet_project.my_data_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class ConsoleMenu implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    private BookService bookService;

    @Override
    public void run(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt();

            switch (choice) {
                case 1 -> booksMenu();
                case 2 -> System.out.println("TODO: фільми");
                case 3 -> System.out.println("TODO: манга");
                case 0 -> running = false;
                default -> System.out.println("Невірний вибір, спробуй ще раз.\n");
            }
        }
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
                case 1 -> bookService.printBooksTable();
                case 2 -> addBook();
                case 3 -> { /* TODO: сам напиши */ }
                case 0 -> inSubMenu = false;
                default -> System.out.println("Невірний вибір.\n");
            }
        }
    }

    public void addBook() {
        Book book = new Book();
        System.out.print("Задайте назву книги: ");
        String name = readString();
        book.setName(name);

        System.out.print("Задайте автора: ");
        String author = readString();
        book.setAuthor(author);

        System.out.print("Задайте рік випуску: ");
        int releaseYear = readInt();
        book.setReleaseYear(releaseYear);

        System.out.print("Задайте кількість сторінок: ");
        int pages = readInt();
        book.setPages(pages);

        System.out.print("Задайте коментар про книгу: ");
        String comment = readString();
        book.setComment(comment);

        bookService.addBook(book);
    }

    //methods for reading
    private int readInt() {
        while (true) {
            if (scanner.hasNextInt()) {
                return Integer.parseInt(scanner.nextLine());
            } else  {
                System.out.println("Це не число. Спробуй ще.");
                scanner.nextLine();
            }
        }

    }
    private String readString() {
        return scanner.nextLine();
    }



}
