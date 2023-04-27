package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command;

import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.ServiceDetails;

import java.util.Scanner;

import static com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.Utility.getFilePathInput;

public class LastEditCommand implements Command {
    @Override
    public String generateResponse(String[] commandParts) {
        String filePath = commandParts[1];
        if (filePath.isBlank()) {
            return "File path cannot be empty";
        }
        if(new java.io.File(filePath).exists()) {
            return new java.util.Date(new java.io.File(filePath).lastModified()).toString();
        } else {
            return "File does not exist";
        }
    }

    @Override
    public String generateRequest(Scanner keyboard) {
        String filePath = getFilePathInput(keyboard);
        return ServiceDetails.LASTEDIT_COMMAND + ServiceDetails.BREAKING_CHARACTER + filePath;
    }

    @Override
    public void handleResponse(String response) {
        System.out.println("Last edit: ");
        System.out.println(response);
    }
}
