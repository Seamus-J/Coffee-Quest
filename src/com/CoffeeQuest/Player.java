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
                if(args.toLowerCase(Locale.ROOT).equals("north")) {

                    // If the player is in the main room
                    if (this.room.getName() == "Main Room"){

                        // If all other room challanges have been completed
                        if (Main.cfq.infiniteLoopRoom.getCompletion()&&
                        Main.cfq.concurrencyRoom.getCompletion()&&
                        Main.cfq.exceptionRoom.getCompletion()){

                            // Set player room to final exam room
                            setRoom(Main.cfq.finalExamRoom);

                            System.out.println("You approach a giant set of stairs littered with skulls and bones from the unfortunate souls who were here before.\n" +
                                    "There are flaming torches leading the way that light up the massive red door awaits on top. It almost looks too heavy to open.\n" +
                                    "You maneuver around the corpses, its like you can hear the whispers of the dead warning you, 'Save Yourself'\n" +
                                    "It frightens you but you have escape some how. You continue until you approach the door. You give it a nudge but it doesn't budge.\n" +
                                    "You put all of your force into, letting out a yell. Finally it starts to creak open.");
                            this.room.getDescription();
                        }
                        else if (this.room.getName() == "Concurrency Room"){
                            System.out.println("You can't take the flashing lights anymore and return to the main room");
                            setRoom(Main.cfq.mainRoom);
                        }
                        else
                        {
                            System.out.println("You approach a giant set of stairs littered with skulls and bones from the unfortunate souls who were here before.\n" +
                                    "There are flaming torches leading the way that light up the massive red door awaits on top. It almost looks too heavy to open.\n" +
                                    "You maneuver around the corpses, its like you can hear the whispers of the dead warning you, 'Save Yourself'\n" +
                                    "It frightens you but you have escape some how. You continue until you approach the door. You give it a nudge but it doesn't budge.\n" +
                                    "You put all of your force into, but it seems to be locked. 'Maybe I should check the other rooms first.' You return to the main room");
                        }
                    }
                    else
                    {
                        System.out.println("There is nothing in that direction");
                    }
                } else if(args.toLowerCase(Locale.ROOT) == "south") {

                    // If the player is in the main room
                    if (this.room.getName() == "Main Room"){

                        // Set the players room to the concurrency room
                        setRoom(Main.cfq.concurrencyRoom);

                        System.out.println("You head towards the tunnel to the east. The tunnel seems to be flashing as if someone was turning on and off a light.\n" +
                                "'Is someone down there?' you yell, but there is no response. As you get closer you hear the faint hum of a machine.\n" +
                                "You finally reach the wooden door where this all coming from and open the door.");
                        this.room.getDescription();
                    }
                    else{
                        System.out.println("There is nothing in that direction");
                    }

                } else if(args.toLowerCase(Locale.ROOT) == "east") {

                    // If the player is in the main room
                    if (this.room.getName() == "Main Room"){

                        // Set the players room to the exception room
                        setRoom(Main.cfq.exceptionRoom);

                        System.out.println("You head down a path covered in spider webs.\n" +
                                "'I hate bugs' you say to yourself\n" +
                                "You can barely see but you navigate your through. 'It seems like the walls moving.'" +
                                "You reach the end and go through the doorway.");
                        this.room.getDescription();
                    }
                    else if (this.room.getName() == "Infinite Loop"){
                        System.out.println("You can't take it anymore, you cover your ears and return to the main room.");
                        setRoom(Main.cfq.mainRoom);
                    }
                    else{
                        System.out.println("There is nothing in that direction");
                    }

                } else if(args.toLowerCase(Locale.ROOT) == "west") {

                    // If the player is in the main room
                    if (this.room.getName() == "Main Room"){

                        // Set the players room to the infinite loop room
                        setRoom(Main.cfq.infiniteLoopRoom);
                        System.out.println("You cautiously start to step forwards to the north down a long hallway that never seems to end00 \n." +
                                "You finally reach a giant metal door, it looks heavy but you attempt to push it open.");
                        this.room.getDescription();
                    }
                    else if (this.room.getName() == "Exception Room"){
                        System.out.println("You rush out the door and down the path back into the main room.");
                        setRoom(Main.cfq.mainRoom);
                    }
                    else {
                        System.out.println("There is nothing in that direction");
                    }
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

