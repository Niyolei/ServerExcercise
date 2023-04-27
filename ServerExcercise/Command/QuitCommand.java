package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command;

import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.ServiceDetails;

import java.util.Scanner;

public class QuitCommand implements Command {

    @Override
    public String generateResponse(String[] commandParts) {
        return "Goodbye";
    }

    @Override
    public String generateRequest(Scanner keyboard) {
        return ServiceDetails.QUIT_COMMAND;
    }

    @Override
    public void handleResponse(String response) {
        System.out.println(response);
    }
}
