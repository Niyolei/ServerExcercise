package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command;

import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.ServiceDetails;

public class CommandFactory {
    public  Command getCommand(String commandName) {
        return switch (commandName){
            case ServiceDetails.EXISTS_COMMAND -> new ExistsCommand();
            case ServiceDetails.LASTEDIT_COMMAND -> new LastEditCommand();
            case ServiceDetails.FIRSTFIVELINES_COMMAND -> new FirstFiveLinesCommand();
            case ServiceDetails.QUIT_COMMAND -> new QuitCommand();
            default -> null;
        };
    }
}
