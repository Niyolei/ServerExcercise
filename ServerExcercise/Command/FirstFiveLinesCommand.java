package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command;

import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.ServiceDetails;

import java.util.Scanner;

import static com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.Utility.getFilePathInput;

public class FirstFiveLinesCommand implements Command {
    @Override
    public String generateResponse(String[] commandParts) {
        String filePath = commandParts[1];
        if (filePath.isBlank()) {
            return "File path cannot be empty";
        }
        if(new java.io.File(filePath).exists()) {
            try {
                java.util.Scanner fileScanner = new java.util.Scanner(new java.io.File(filePath));
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    if (fileScanner.hasNextLine()) {
                        output.append(fileScanner.nextLine());
                        output.append(ServiceDetails.BREAKING_CHARACTER);
                    }
                }
                return output.toString();
            } catch (java.io.FileNotFoundException e) {
                return "File not found";
            }
        }
        else {
            return "File does not exist";
        }
    }

    @Override
    public String generateRequest(Scanner keyboard) {
        String filePath = getFilePathInput(keyboard);
        return ServiceDetails.FIRSTFIVELINES_COMMAND + ServiceDetails.BREAKING_CHARACTER + filePath;
    }

    @Override
    public void handleResponse(String response) {
        System.out.println("First five lines: ");
        String [] lines = response.split(ServiceDetails.BREAKING_CHARACTER);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
