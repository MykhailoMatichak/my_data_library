package com.pet_project.my_data_library.console;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {
    Scanner scanner = new Scanner(System.in);
    //methods for reading
    public int readInt() {
        while(true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e)  {
                System.out.println("Це не число. Спробуй ще.");
            }
        }
    }
    public String readString() {
        return scanner.nextLine();
    }
}
