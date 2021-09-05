package com.CoffeeQuest;

import java.lang.reflect.Array;
import java.util.Locale;
import java.util.Scanner;

public class Commands {
//    Create item array
//    Items itemsArray = {};
    String[] commands = {"help", "move", "talk", "pickup", "use", "drop", "quit", "where am i"};
    String[] commandDescription = {"Get this list", "Move to the selected room.", "Talk to an NPC", "Pickup an item", "Use a selected Item", "Drop an item", "Quit the game", "Gives brief description of surroundings"};
    String command = "";
    String args = "";
    Scanner input;

    public Commands(Scanner userInput) {
        // do nothing.
        // Capture user input incase we need it.
        input = userInput;
    }

    public void getCommands(String inputCommand) {
        String[] cmdString = inputCommand.split("\\s");
        command = cmdString[0];
        switch(command.toLowerCase(Locale.ROOT)) {
            case "help":
                if(args != "") {
                    System.out.println(command + args);
                } else {
                    listCommands();
                }
                break;
            case "quit": quit();
                break;
            case "where am i": // Setup where am I command
                break;
            case "use":
                break;
            case "drop":
                break;
            case "move":
                break;
            case "talk":
                break;
            case "pickup":
                break;
            default: System.out.println("Didn't understand that command");
        }
    }

    private void listCommands() {
        System.out.println("List of commands:");
        int i = 1;
        while(i < commands.length) {
            for(String command : commands) {
                System.out.println(command + " <arg> - " + commandDescription[i - 1]);
                i++;
            }
        }
        System.out.println("");
    }

    private void quit() {
        System.out.println("Quitting game....");
        System.exit(0);
    }
}
