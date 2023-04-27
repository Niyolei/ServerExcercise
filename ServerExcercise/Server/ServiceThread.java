package com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Server;

import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command.Command;
import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Command.CommandFactory;
import com.dkit.gd2.dominikhampejs.Sem2.ServerExcercise.Core.ServiceDetails;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServiceThread extends Thread{
    private Socket socket;
    private int clientCount;
    private Scanner input;
    private PrintWriter output;

    public ServiceThread(ThreadGroup threadGroup, String s, Socket socket, int clientCount) {
        super(threadGroup, s);
        this.socket = socket;
        this.clientCount = clientCount;

        try {
            input = new Scanner(socket.getInputStream());
            output = new PrintWriter(socket.getOutputStream(), true);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        String incomingCommand = "";
        String response;

        try {
            while (!incomingCommand.equals(ServiceDetails.QUIT_COMMAND)){
                incomingCommand = input.nextLine();
                System.out.println("Command received: " + incomingCommand);

                String[] commandParts = incomingCommand.split(ServiceDetails.BREAKING_CHARACTER);

                CommandFactory commandFactory = new CommandFactory();

                Command command = commandFactory.getCommand(commandParts[0]);

                if (command == null)
                    throw new Exception("Command not found");
                else {
                    response = command.generateResponse(commandParts);
                    System.out.println("Response: " + response);

                    output.println(response);
                    System.out.println("Response sent to client");
                }
            }
            socket.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
