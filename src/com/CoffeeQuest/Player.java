package com.CoffeeQuest;

import java.util.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    // 2.2 --Example of encapsulation (1)--also note the public methods and use of get/set methods
    private Rooms room;
    private ArrayList<Items> inventory;
    private List<Items> roomInventory;
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
                // To tell if the player has it in their inventory
                boolean inInventory = false;
                Items holder = null;

                // Loop thru inventory to try and find the item
                for(Items i : inventory){
                    if (i.getName().equals(args.toLowerCase(Locale.ROOT))){
                        inInventory = true;
                        holder = i;
                    }
                }

                if (inInventory){
                    use(holder);
                }
                else
                {
                    System.out.println("You do not have this item");
                }
                break;
            case "move":
                switch (args.toLowerCase(Locale.ROOT)) {
                    case "north":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // If all other room challenges have been completed
                            if (CoffeeQuest.infiniteLoopRoom.GetCompletion() &&
                                    CoffeeQuest.concurrencyRoom.GetCompletion() &&
                                    CoffeeQuest.exceptionRoom.GetCompletion()) {

                                // Set player room to final exam room
                                setRoom(CoffeeQuest.finalExamRoom);

                                System.out.println(this.room.getDescription());
                            } else {
                                System.out.println(CoffeeQuest.finalExamRoom.getDescription());
                            }
                        } else if (this.room.getName() == "Concurrency Room") {

                            // If the player leaves without completing the room
                            if (!this.room.GetCompletion()){
                                System.out.println("\nYou can't take the flashing lights anymore and return to the main room\n");
                                setRoom(CoffeeQuest.mainRoom);
                            }
                            else {
                                System.out.println("\nYou head back to the main room.\n");
                                setRoom(CoffeeQuest.mainRoom);
                            }

                        } else {
                            System.out.println("\nThere is nothing in that direction\n");
                        }
                        break;
                    case "south":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // Set the players room to the concurrency room
                            setRoom(CoffeeQuest.concurrencyRoom);

                            // If the player has completed the room, print a prompt reminding them
                            if (this.room.GetCompletion()){
                                System.out.println("There is nothing to do here.\n" +
                                        "Unless you are looking for an Item I would head back where you came from.\n");
                            }
                            else{
                                // Display room description if not complete
                                System.out.println(this.room.getDescription());
                            }

                            // Display items in the room
                            roomInventory = this.room.getItems();
                            System.out.println("Objects in room: ");
                            roomInventory.forEach(x -> System.out.println(x));
                        } else {
                            System.out.println("\nThere is nothing in that direction");
                        }

                        break;
                    case "east":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // Set the players room to the exception room
                            setRoom(CoffeeQuest.exceptionRoom);

                            // If the player has completed the room, print a prompt reminding them
                            if (this.room.GetCompletion()){
                                System.out.println("There is nothing to do here.\n" +
                                        "Unless you are looking for an Item I would head back where you came from.\n");
                            }
                            else{
                                // Display room description if not complete
                                System.out.println(this.room.getDescription());
                            }

                            // Display items in the room
                            roomInventory = this.room.getItems();
                            System.out.println("Objects in room: ");
                            roomInventory.forEach(x -> System.out.println(x));

                        } else if (Objects.equals(this.room.getName(), "Infinite Loop")) {
                            // If the player leaves without completing the room
                            if (!this.room.GetCompletion()){
                                System.out.println("\nYou can't take it anymore, you cover your ears and return to the main room.\n");
                                setRoom(CoffeeQuest.mainRoom);
                            }
                            else {
                                System.out.println("\nYou head back to the main room.\n");
                                setRoom(CoffeeQuest.mainRoom);
                            }
                        } else {
                            System.out.println("\nThere is nothing in that direction");
                        }

                        break;
                    case "west":

                        // If the player is in the main room
                        if (Objects.equals(this.room.getName(), "Main Room")) {

                            // Set the players room to the infinite loop room
                            setRoom(CoffeeQuest.infiniteLoopRoom);

                            // If the player has completed the room, print a prompt reminding them
                            if (this.room.GetCompletion()){
                                System.out.println("There is nothing to do here.\n" +
                                        "Unless you are looking for an Item I would head back where you came from.\n");
                            }
                            else{
                                // Display room description if not complete
                                System.out.println(this.room.getDescription());
                            }

                            // Display the items in the room
                            roomInventory = this.room.getItems();
                            System.out.println("Objects in room: ");
                            roomInventory.forEach(x -> System.out.println(x));

                        } else if (Objects.equals(this.room.getName(), "Exception Room")) {

                            // If the player leaves without completing the room
                            if (!this.room.GetCompletion()){
                                System.out.println("\nYou rush out the door and down the path back into the main room.\n");
                                setRoom(CoffeeQuest.mainRoom);
                            }
                            else {
                                System.out.println("\nYou head back to the main room.\n");
                                setRoom(CoffeeQuest.mainRoom);
                            }
                        } else {
                            System.out.println("\nThere is nothing in that direction");
                        }
                        break;
                }
                break;

        case "look":
            System.out.println(room.getDescription());
            roomInventory = this.room.getItems();
            System.out.println("Objects in room: ");
            roomInventory.forEach(x -> System.out.println(x));
            break;
        case "pickup":
            if(args.toLowerCase(Locale.ROOT).equals("hammer")){
                pickUp("hammer");
            }
            else if(args.toLowerCase(Locale.ROOT).equals("flashlight")){
                pickUp("flashlight");
            }
            else if(args.toLowerCase(Locale.ROOT).equals("battery")){
                pickUp("battery");
            }
            else if(args.toLowerCase(Locale.ROOT).equals("kitkat")){
                pickUp("kitkat");
            }
            else if(args.toLowerCase(Locale.ROOT).equals("poison")){
                pickUp("poison");
            }
            else
            {
                System.out.println("That item is not recognized");
            }
            break;
            case "drop":
            if(args.toLowerCase(Locale.ROOT).equals("hammer")){
                drop("hammer");
            }
            else if(args.toLowerCase(Locale.ROOT).equals("key")){
                drop("key");
            }
            else if(args.toLowerCase(Locale.ROOT).equals("flashlight")){
                drop("flashlight");
            }
            else
            {
                System.out.println("That item is not recognized");
            }
            break;
            case "talk":
                // TODO: Find a way to talk to an NPC
                CoffeeQuest.npc.GreetPlayer();
                break;
            case "whatis":
                item = cmds.getItem(args);
                System.out.println(item.getName() + " is " + item.getDescription());
                break;
            case "inventory":
//              Return all the items in the inventory.
//              Big brain move right here.... - Billy ;)
                System.out.println("You have the following items in your inventory: ");
                inventory.forEach(x -> System.out.println(x));
                break;
            case "cheat":
                CoffeeQuest.concurrencyRoom.setCompletion(true);
                CoffeeQuest.exceptionRoom.setCompletion(true);
                CoffeeQuest.infiniteLoopRoom.setCompletion(true);
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
    private void pickUp(String itemName)
    {
        Items holder = null;
        //If the room contains the item, transfer it to the player's inventory
        for(Items currentItem : roomInventory)
        {
            if(currentItem.getName().equals(itemName)){
                System.out.println("You picked up: " + currentItem.getName());
                transferItem(currentItem, roomInventory, inventory);
                holder = currentItem;
                break;
            }
        }
        if(holder == null){
            System.out.println("That item is not recognized");
        }
    }

    // Use an item
    private void use(Items item) {

        // If statement to see what item the player used

        if(item.getName().equals("battery")){
            // If they are in the Concurrency Room
            if (Objects.equals(this.room.getName(), "Concurrency Room")){
                // Remove item, print description, complete the room
                inventory.remove(item);
                System.out.println(item.useItemDescription());
                this.room.IsCompletion(true);
            }
            else{
                // If not in right room, do nothing
                System.out.println("\nThere is no use for that here");
            }
        }
        else if (item.getName().equals("flashlight")){
            // If they are in the Infinite loop room
            if (Objects.equals(this.room.getName(), "Infinite Loop")){
                // print description, complete the room
                CoffeeQuest.infiniteLoopRoom.IsDark(false);
                System.out.println(item.useItemDescription());
            }
            else{
                System.out.println("\nIt is already bright in this room.");
            }
        }
        else if(item.getName().equals("hammer")){
            // If they are in the infinite loop room
            if (Objects.equals(this.room.getName(), "Infinite Loop")){
                // Remove item, print description, complete the room
                if (!CoffeeQuest.infiniteLoopRoom.GetIsDark()){
                    inventory.remove(item);
                    System.out.println(item.useItemDescription());
                    this.room.IsCompletion(true);
                }
                else{
                    System.out.println("I can't see anything, I need some light first before I swing this hammer!");
                }
            }
            else{
                System.out.println("\nThere is no use for that here");
            }
        }
        else if(item.getName().equals("kitkat")){
            // If in infinite loop room
            if (Objects.equals(this.room.getName(), "Infinite Loop")){
                // Remove item, print description, complete the room
                inventory.remove(item);
                System.out.println(item.useItemDescription());
                this.room.IsCompletion(true);
            }
            else{
                inventory.remove(item);
                System.out.println("\nMmm that's good, do you think I could have used these late on?\n" +
                        "I guess we will never know.");
            }
        }
        else if (item.getName().equals("poison")){
            // If in exception room
            if (Objects.equals(this.room.getName(), "Exception Room")){
                // Remove item, print description, complete the room
                inventory.remove(item);
                System.out.println(item.useItemDescription());
                this.room.IsCompletion(true);
            }
            else{
                System.out.println("\nThere is no use for that here");
            }
        }
    }

    //Drop an item
    private void drop(String itemName)
    {
        Items holder = null;
        //If the room contains the item, transfer it to the player's inventory
        for(Items currentItem : inventory)
        {
            if(currentItem.getName().equals(itemName)){
                System.out.println("You dropped: " + currentItem.getName());
                transferItem(currentItem, inventory, roomInventory);
                holder = currentItem;
                break;
            }
        }
        if(holder == null){
            System.out.println("That item is not in your inventory");
        }
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
        System.out.println("Your inventory: ");
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

    private void transferItem(Items x, List<Items> fromList, List<Items> toList){
        fromList.remove(x);
        toList.add(x);
    }
}

