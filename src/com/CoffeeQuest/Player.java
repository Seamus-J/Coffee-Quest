package com.CoffeeQuest;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Player {
    //Private variables
    private Rooms room;
    private ArrayList<Items> inventory;
    private Scanner input = new Scanner(System.in);
    private Commands cmds = new Commands();
    private String command = "";
    private String args = "";
    private Items item;
    //Constructor
    public Player(Rooms room)
    {
        this.room = room;
        // Build a new array list of an inventory when the user starts the game.
        setInventory(new ArrayList<Items>());
        // Print out the initial text for the user to see.
        System.out.println("Welcome");
        // Print out the lore and context of whats happening.
        System.out.println("Insert lore here");
        while(true) {
            System.out.println("What do you want to do next?");
            System.out.print("> ");
            getCommands(input.nextLine());
        }
    }

    //Methods
    // Commands
    /**
     * @param inputCommand
     */
    public void getCommands(String inputCommand) {
        String[] cmdString = inputCommand.split("\\s");
        command = cmdString[0];
        args = cmdString[1];
        switch(command.toLowerCase(Locale.ROOT)) {
            case "help":
                if(args != "") {
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
                // TODO: Find a way to move to another room
                // TODO: Based off which room they are in, give them a set of directions they can go. IE, make sure they can't go west if there is no door to the west.
                if(args.toLowerCase(Locale.ROOT) == "north") {
                    if (this.room.getName() == "Main Room"){
                        this.room = Main.cfq.infiniteLoopRoom;
                        System.out.println("You cautiously start to step forwards to the north down a long hallway that never seems to end00 \n." +
                                "You finally reach a giant metal door, it looks heavy but you attempt to push it open.");
                        this.room.getDescription();
                    }

                } else if(args.toLowerCase(Locale.ROOT) == "south") {

                } else if(args.toLowerCase(Locale.ROOT) == "east") {

                } else if(args.toLowerCase(Locale.ROOT) == "west") {

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

