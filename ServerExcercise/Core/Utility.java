package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core;

import java.util.Scanner;

public class Utility {
    public static String getFilePathInput(Scanner keyboard) {
        while (true){
            System.out.println("Enter the file path: ");
            String filePath = keyboard.nextLine();
            if (filePath.isBlank()) {
                System.out.println("File path cannot be empty");
            } else {
                return filePath;
            }
        }
    }
}
