package com.pet_project.my_data_library.console;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.pet_project.my_data_library.persistence.entity.Film;
import com.pet_project.my_data_library.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FilmsMenu {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ConsoleReader consoleReader;

    public void menu() {
        boolean inSubmenu = true;
        while (inSubmenu) {
            System.out.println("""
                    -- Фільми --
                    1. Показати всі
                    2. Додати
                    3. Видалити
                    0. Назад
                    """);
            int choice = consoleReader.readInt();
            switch (choice) {
                case 1 -> printFilmTable();
                case 2 -> addFilm();
                case 3 -> deleteFilm();
                case 0 -> inSubmenu = false;
                default -> System.out.println("Невірний вибір.\n");
            }
        }
    }

    private void printFilmTable() {
        List<Film> films = filmService.getAllFilms();
        System.out.println(AsciiTable.getTable(
                AsciiTable.FANCY_ASCII,
                films,
                Arrays.asList(
                        new Column().header("№").with(film -> String.valueOf(films.indexOf(film) + 1)),
                        new Column().header("Name").with(film -> film.getName()),
                        new Column().header("Director").with(film -> film.getDirector()),
                        new Column().header("Release year").with(film -> String.valueOf(film.getReleaseYear())),
                        new Column().header("Duration").with(film -> String.valueOf(film.getDuration())),
                        new Column().header("Create date").with(film -> String.valueOf(film.getCreatedDate()).substring(0, 10)),
                        new Column().header("Comment").with(film -> film.getComment())
                )
        ));
    }

    private void addFilm() {
        System.out.print("Задайте назву фільма: ");
        String name = consoleReader.readString();

        System.out.print("Задайте режисера: ");
        String director = consoleReader.readString();

        System.out.print("Задайте рік випуску: ");
        int releaseYear = consoleReader.readInt();

        System.out.print("Задайте кількість хв : ");
        int duration = consoleReader.readInt();

        System.out.print("Бажаєте додати коментар?(y/n): ");
        String answer = consoleReader.readString();
        String comment = null;
        if(answer.equalsIgnoreCase("y")){
            System.out.print("Задайте коментар про фільм: ");
            comment = consoleReader.readString();
        }

        //write to object film
        Film film = new Film();
        film.setName(name);
        film.setDirector(director);
        film.setReleaseYear(releaseYear);
        film.setDuration(duration);
        film.setComment(comment);

        filmService.addFilm(film);
    }

    private void deleteFilm() {
        List<Film> films = filmService.getAllFilms();
        System.out.print("Введіть №: ");
        int num = consoleReader.readInt();
        if(num < 1 || num > films.size()) {
            System.out.println("Невірний номер. Всього фільмів: " + films.size());
            return;
        }

        Film film = films.get(num - 1);
        filmService.deleteFilm(film.getId());
        System.out.println("Фільм успішно видалено.");
    }

}
