package com.CoffeeQuest;

import java.util.*;

public class Player {
    // 2.2 --Example of encapsulation (1)--also note the public methods and use of get/set methods
    private Rooms room;
    private ArrayList<Items> inventory;
    private List<Items> roomInventory;
    private Scanner input = new Scanner(System.in);
    private Commands cmds;
    private String command = "";
    private String args = "";
    private Items item;
    private final String hammer = "hammer";
    private final String key = "key";
    private final String flashlight = "flashlight";

    //Constructor
    public Player(Rooms room)
    {
        this.room = room;

        // Build a new array list of an inventory when the user starts the game.
        setInventory(new ArrayList<Items>());

        // Print out the initial text for the user to see.
        System.out.println("Welcome to Coffee Quest!");

        // Print out the lore and context of what's happening.
        System.out.println("Insert lore here");
        while(true) {
            System.out.println("\nWhat do you want to do next?");
            System.out.print("> ");
            getCommands(input.nextLine());
        }
    }

    /**
     * @param inputCommand
     */
    public void getCommands(String inputCommand){

        boolean wrongInput = false;

        String[] cmdString = inputCommand.split("\\s");


        if(cmdString.length ==1  && cmdString[0].equals("help"))
        {
            cmds.listCommands();
        }
        else if(cmdString.length ==1 && cmdString[0].equals("quit"))
        {
            cmds.quit();
        }
        else if(cmdString.length ==1 && cmdString[0].equals("inventory"))
        {
                System.out.println("You have the following items in your inventory: ");
                inventory.forEach(x -> System.out.println(x));
        }
        else
        {
            try{
            command = cmdString[0];
            args = cmdString[1] ;
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Your command is unclear. Make sure to include an argument with your command");
                wrongInput = true;
            }

if(wrongInput == false)
{
    switch(command.toLowerCase(Locale.ROOT)) {

        case "look":
            System.out.println(room.getDescription());
            break;
        case "pickup":
            if(args.toLowerCase(Locale.ROOT).equals("hammer")){
                pickUp(hammer);
            }
            else if(args.toLowerCase(Locale.ROOT).equals("key")){
                pickUp(key);
            }
            else if(args.toLowerCase(Locale.ROOT).equals("flashlight")){
                pickUp(flashlight);
            }
            else
            {
                System.out.println("That item is not recognized");
            }
            break;
        case "use":
            //TODO: Find a way to use an item of class Item.
            item = cmds.getItem(args);
            use(item);
            break;
        case "drop":
            if(args.toLowerCase(Locale.ROOT).equals("hammer")){
                drop(hammer);
            }
            else if(args.toLowerCase(Locale.ROOT).equals("key")){
                drop(key);
            }
            else if(args.toLowerCase(Locale.ROOT).equals("flashlight")){
                drop(flashlight);
            }
            else
            {
                System.out.println("That item is not recognized");
            }
            break;
        case "move":
            if(args.toLowerCase(Locale.ROOT).equals("north")) {
                // If the player is in the main room
                if (this.room.getName() == "Main Room"){

                    // If all other room challenges have been completed
                    if (CoffeeQuest.infiniteLoopRoom.getCompletion()&&
                            CoffeeQuest.concurrencyRoom.getCompletion()&&
                            CoffeeQuest.exceptionRoom.getCompletion()){

                        // Set player room to final exam room
                        setRoom(CoffeeQuest.finalExamRoom);

                        System.out.println("You approach a giant set of stairs littered with skulls and bones from the unfortunate souls who were here before.\n" +
                                "There are flaming torches leading the way that light up the massive red door awaits on top. It almost looks too heavy to open.\n" +
                                "You maneuver around the corpses, its like you can hear the whispers of the dead warning you, 'Save Yourself'\n" +
                                "It frightens you but you have escape some how. You continue until you approach the door. You give it a nudge but it doesn't budge.\n" +
                                "You put all of your force into, letting out a yell. Finally it starts to creak open.");
                        System.out.println();
                        System.out.println(this.room.getDescription());
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
                else if (this.room.getName() == "Concurrency Room"){
                    System.out.println("\nYou can't take the flashing lights anymore and return to the main room");
                    setRoom(CoffeeQuest.mainRoom);
                }
                else
                {
                    System.out.println("\nThere is nothing in that direction");
                }

            } else if(args.toLowerCase(Locale.ROOT).equals("south")) {

                // If the player is in the main room
                if (this.room.getName() == "Main Room"){

                    // Set the players room to the concurrency room
                    setRoom(CoffeeQuest.concurrencyRoom);

                    System.out.println("You head towards the tunnel to the east. The tunnel seems to be flashing as if someone was turning on and off a light.\n" +
                            "'Is someone down there?' you yell, but there is no response. As you get closer you hear the faint hum of a machine.\n" +
                            "You finally reach the wooden door where this all coming from and open the door.\n");
                    System.out.println(this.room.getDescription());
                    roomInventory = this.room.getItems();

                    System.out.println("Objects in room: ");
                    roomInventory.forEach(x -> System.out.println(x));
                }
                else{
                    System.out.println("There is nothing in that direction");
                }

            } else if(args.toLowerCase(Locale.ROOT).equals("east")) {

                // If the player is in the main room
                if (this.room.getName() == "Main Room"){

                    // Set the players room to the exception room
                    setRoom(CoffeeQuest.exceptionRoom);

                    System.out.println("You head down a path covered in spider webs.\n" +
                            "'I hate bugs' you say to yourself\n" +
                            "You can barely see but you navigate your through. 'It seems like the walls moving.'" +
                            "You reach the end and go through the doorway.");
                    System.out.println();
                    System.out.println(this.room.getDescription());
                }
                else if (this.room.getName() == "Infinite Loop"){
                    System.out.println("You can't take it anymore, you cover your ears and return to the main room.");
                    setRoom(CoffeeQuest.mainRoom);
                }
                else{
                    System.out.println("There is nothing in that direction");
                }


            } else if(args.toLowerCase(Locale.ROOT).equals("west")) {

                // If the player is in the main room
                if (this.room.getName() == "Main Room"){

                    // Set the players room to the infinite loop room
                    setRoom(CoffeeQuest.infiniteLoopRoom);
                    System.out.println("You cautiously start to step forwards to the north down a long hallway that never seems to end00 \n." +
                            "You finally reach a giant metal door, it looks heavy but you attempt to push it open.\n");
                    System.out.println(this.room.getDescription());
                }
                else if (this.room.getName() == "Exception Room"){
                    System.out.println("You rush out the door and down the path back into the main room.");
                    setRoom(CoffeeQuest.mainRoom);
                }
                else {
                    System.out.println("There is nothing in that direction");
                }
            }
            else
            {
                System.out.println("Let's stick with the cardinal directions: north, south, east, and west");
            }
            break;
        case "talk":
            // TODO: Find a way to talk to an NPC
            break;
        case "whatis":
            item = cmds.getItem(args);
            System.out.println(item.getName() + " is " + item.getDescription());
            break;
        default: System.out.println("Didn't understand that command");
    }
}
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
        if(item.getName().equals("mushroom")){
            inventory.remove(item);
        }
        inventory.remove(item);
        System.out.println("You used " + item.getName());
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

