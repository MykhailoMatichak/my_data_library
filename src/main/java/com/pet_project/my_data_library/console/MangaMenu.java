package com.pet_project.my_data_library.console;


import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.pet_project.my_data_library.persistence.entity.Manga;
import com.pet_project.my_data_library.service.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MangaMenu {

    @Autowired
    private MangaService mangaService;
    @Autowired
    private ConsoleReader consoleReader;

    public void menu(){
        boolean inSubMenu = true;
        while(inSubMenu){
            System.out.println("""
                    -- Манги --
                    1. Показати всі
                    2. Додати
                    3. Видалити
                    0. Назад
                    """);
            int choice = consoleReader.readInt();
            switch(choice){
                case 1 -> printMangaTable();
                case 2 -> addManga();
                case 3 -> deleteManga();
                case 0 -> inSubMenu = false;
                default -> System.out.println("Невірний вибір.\n");
            }
        }
    }

    private void printMangaTable(){
        List<Manga> mangas = mangaService.getAllMangas();
        System.out.println(AsciiTable.getTable(
                AsciiTable.FANCY_ASCII,
                mangas,
                Arrays.asList(
                        new Column().header("№").with(manga -> String.valueOf(mangas.indexOf(manga) + 1)),
                        new Column().header("Name").with(manga -> manga.getName()),
                        new Column().header("Author").with(manga -> manga.getAuthor()),
                        new Column().header("Release year").with(manga -> String.valueOf(manga.getReleaseYear())),
                        new Column().header("Create date").with(manga -> String.valueOf(manga.getCreatedDate()).substring(0, 10)),
                        new Column().header("Comment").with(manga -> manga.getComment())
                )
        ));
    }

    private void addManga() {
        System.out.print("Задайте назву манги: ");
        String name = consoleReader.readString();

        System.out.print("Задайте автора: ");
        String author = consoleReader.readString();

        System.out.print("Задайте рік випуску: ");
        int releaseYear = consoleReader.readInt();

        System.out.print("Бажаєте додати коментар?(y/n): ");
        String answer = consoleReader.readString();
        String comment = null;
        if(answer.equalsIgnoreCase("y")){
            System.out.print("Задайте коментар про мангу: ");
            comment = consoleReader.readString();
        }

        //write to object film
        Manga manga = new Manga();
        manga.setName(name);
        manga.setAuthor(author);
        manga.setReleaseYear(releaseYear);
        manga.setComment(comment);

        mangaService.addManga(manga);
    }

    private void deleteManga() {
        List<Manga> mangas = mangaService.getAllMangas();
        System.out.print("Введіть №: ");
        int num = consoleReader.readInt();
        if (num < 1 || num > mangas.size()){
            System.out.println("Невірний номер. Всього манг: " + mangas.size());
        }

        Manga manga = mangas.get(num - 1);
        System.out.println("Книгу успішно видалено.");
        mangaService.deleteManga(manga.getId());
    }
}





