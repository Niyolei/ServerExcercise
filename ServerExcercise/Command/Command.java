package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command;

import java.util.Scanner;

public interface Command {
    public String generateResponse(String[] commandParts);
    public String generateRequest(Scanner keyboard);
    public void handleResponse(String response);
}
