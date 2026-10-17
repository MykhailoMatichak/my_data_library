package com.pet_project.my_data_library.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;



@Component
public class ConsoleMenu implements CommandLineRunner {

    @Autowired
    private BooksMenu booksMenu;
    @Autowired
    private FilmsMenu filmsMenu;
    @Autowired
    private MangaMenu mangaMenu;
    @Autowired
    private ConsoleReader consoleReader;

    @Override
    public void run(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = consoleReader.readInt();

            switch (choice) {
                case 1 -> booksMenu.menu();
                case 2 -> filmsMenu.menu();
                case 3 -> mangaMenu.menu();
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


}
