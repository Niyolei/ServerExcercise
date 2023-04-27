package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command;

import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.ServiceDetails;

import java.util.Scanner;
import java.io.File;

import static com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.Utility.getFilePathInput;

public class ExistsCommand implements Command {

    @Override
    public String generateResponse(String[] commandParts) {
        String filePath = commandParts[1];
        if (filePath.isBlank()) {
            return "File path cannot be empty";
        }
        //https://stackoverflow.com/questions/1816673/how-do-i-check-if-a-file-exists-in-java found on StackOverflow;
        if(new File(filePath).exists()) {
            return "TRUE";
        } else {
            return "FALSE";
        }
    }

    @Override
    public String generateRequest(Scanner keyboard) {
        String filePath = getFilePathInput(keyboard);
        return ServiceDetails.EXISTS_COMMAND + ServiceDetails.BREAKING_CHARACTER + filePath;
    }

    @Override
    public void handleResponse(String response) {
        System.out.print("File exists: ");
        System.out.println(response);
    }
}
