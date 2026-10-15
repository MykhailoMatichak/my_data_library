package com.pet_project.my_data_library.console;

import java.util.Scanner;

public class ConsoleReader {
    Scanner scanner = new Scanner(System.in);
    //methods for reading
    public int readInt() {
        while(true) {
            if(scanner.hasNextInt()) {
                return Integer.parseInt(scanner.nextLine());
            } else  {
                System.out.println("Це не число. Спробуй ще.");
                scanner.nextLine();
            }
        }
    }
    public String readString() {
        return scanner.nextLine();
    }
}
