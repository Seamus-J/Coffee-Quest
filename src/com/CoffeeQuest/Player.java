package com.CoffeeQuest;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    //Private variables
    private Rooms room;
    private ArrayList<Items> inventory;
    private Scanner input = new Scanner(System.in);
    private Commands cmds = new Commands();
    private Items item;
    //Constructor
    public Player(Rooms room)
    {
        this.room = room;
        // Build a new array list of an inventory when the user starts the game.
        setInventory(new ArrayList<Items>());
        // Print out the lore and context of what's happening.
        System.out.println("\n\nWelcome to Coffee Quest! The text-based adventure game that leads you through trials and tribulations\n" +
                "that you have to overcome in order to escape the perilous dungeons of the Java Master.\n\n" +
                "type 'help' for a list of commands\n");
        while(true) {
            System.out.println("What do you want to do next?");
            System.out.print("> ");
            getCommands(input.nextLine());
        }
    }

    /**
     * This method gets the user input and splits it into commands for the switch statement
     * and args for the if conditions
     * @param inputCommand
     */
    public void getCommands(String inputCommand) {
        String command = "";
        String args = "";
        String[] cmdString = inputCommand.split("\\s");
        command = cmdString[0];

        // Validation for if the user entered only one word
        if (cmdString.length > 1){
            args = cmdString[1];
        }

        switch(command.toLowerCase(Locale.ROOT)) {
            case "help":
                if(!Objects.equals(args, "")) {
                    System.out.println(command + args);
                } else {
                    cmds.listCommands();
                }
                break;
            case "quit": cmds.quit();
                break;
            case "where am i": // Setup where am I command
                // TODO: Repeat where the user moved to.
                room.getDescription();
                break;
            case "use":
                //TODO: Find a way to use an item of class Item.
                item = cmds.getItem(args);
                use(item);
                break;
            case "drop":
                // TODO: Find a way to drop an item of class Item.
                item = cmds.getItem(args);
                drop(item);
                break;
            case "move":
                switch (args.toLowerCase(Locale.ROOT)) {
                    case "north":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // If all other room challanges have been completed
                            if (CoffeeQuest.infiniteLoopRoom.getCompletion() &&
                                    CoffeeQuest.concurrencyRoom.getCompletion() &&
                                    CoffeeQuest.exceptionRoom.getCompletion()) {

                                // Set player room to final exam room
                                setRoom(CoffeeQuest.finalExamRoom);

                                System.out.println(this.room.getDescription());
                            } else {
                                System.out.println(CoffeeQuest.finalExamRoom.getDescription());
                            }
                        } else if (this.room.getName() == "Concurrency Room") {
                            System.out.println("\nYou can't take the flashing lights anymore and return to the main room");
                            setRoom(CoffeeQuest.mainRoom);
                        } else {
                            System.out.println("\nThere is nothing in that direction");
                        }
                        break;
                    case "south":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // Set the players room to the concurrency room
                            setRoom(CoffeeQuest.concurrencyRoom);

                            System.out.println(this.room.getDescription());
                        } else {
                            System.out.println("\nThere is nothing in that direction");
                        }

                        break;
                    case "east":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // Set the players room to the exception room
                            setRoom(CoffeeQuest.exceptionRoom);

                            System.out.println(this.room.getDescription());
                        } else if (Objects.equals(this.room.getName(), "Infinite Loop")) {
                            System.out.println("\nYou can't take it anymore, you cover your ears and return to the main room.");
                            setRoom(CoffeeQuest.mainRoom);
                        } else {
                            System.out.println("\nThere is nothing in that direction");
                        }

                        break;
                    case "west":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // Set the players room to the infinite loop room
                            setRoom(CoffeeQuest.infiniteLoopRoom);
                            System.out.println(this.room.getDescription());
                        } else if (Objects.equals(this.room.getName(), "Exception Room")) {
                            System.out.println("\nYou rush out the door and down the path back into the main room.");
                            setRoom(CoffeeQuest.mainRoom);
                        } else {
                            System.out.println("\nThere is nothing in that direction");
                        }
                        break;
                }
                break;
            case "talk":
                // TODO: Find a way to talk to an NPC
                break;
            case "pickup":
                // TODO: Find a way to pick up an item of class Item
                item = cmds.getItem(args);
                pickUp(item);
                break;
            case "whatis":
                item = cmds.getItem(args);
                System.out.println(item.getName() + " is " + item.getDescription());
                break;
            case "inventory":
//              Return all the items in the inventory.
//              Big brain move right here.... - Billy ;)
                System.out.println("You have: ");
                getInventory().forEach(i -> i.getName());
                break;
            default: System.out.println("Didn't understand that command");
        }
    }

    /**
     * This method intakes the players commands
     */
    public void input() {
        while (true) {
            System.out.println("What do you want to do next?");
            System.out.print("> ");
            getCommands(input.nextLine());
        }
    }

    //Pick-up an item
    private void pickUp(Items item)
    {
        inventory.add(item);
        System.out.println("You picked up " + item.getName());
    }

    // Use an item
    private void use(Items item) {
        inventory.remove(item);
        System.out.println("You used " + item.getName());
    }

    //Drop an item
    private void drop(Items item)
    {
        inventory.remove(item);
        System.out.println("You dropped " + item.getName());
    }

    //Get inventory
    private ArrayList<Items> getInventory()
    {
        return inventory;
    }

    //Set inventory
    private void setInventory(ArrayList<Items>inventory)
    {
        this.inventory = inventory;
    }

    //Return room player is currently in
    private Rooms GetRoom()
    {
        return room;
    }

    //Set the current room as the player's location
    private void setRoom(Rooms room)
    {
        this.room = room;
    }

    // TO DO: class for using items(to be designed based off of items)

    private void showItems()
    {
        System.out.println("Your inventory:");
        System.out.println();

        //Check to see if there are items in inventory
        if(inventory.size()==0)
        {
            System.out.println("There are no items in your inventory");
        }
        else
        {
            //Loop through entire inventory, listing each item
            for(int x=0; x<inventory.size(); x++)
            {
                System.out.println(inventory.get(x));
            }
        }
        //Print a blank line to create space for user entry
        System.out.println();
    }

}

