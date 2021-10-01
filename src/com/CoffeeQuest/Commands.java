package com.CoffeeQuest;


//TODO: When the items are created, create an enum for the switch-case statement to utilize.
//public enum ItemTypes {
//
//}

public class Commands {
//    Create item array
//    Items itemsArray = {};
    String[] commands = {"help", "move", "talk", "pickup", "use", "drop", "quit", "look"};
    String[] commandDescription = {"Get this list", "Move to the selected room.", "Talk to an NPC", "Pickup an item", "Use a selected Item", "Drop an item", "Quit the game", "Gives brief description of surroundings"};
    Rooms currentRoom;

    public Commands() {
        // do nothing.
    }

    /**
     *
     */
    public void listCommands() {
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

    /**
     *
     */
    public void quit() {
        System.out.println("Quitting game....");
        System.exit(0);
    }

    public Items getItem(String arg) {
        Item item = new Item();
        // Return the class of Item used to pickup, drop, or use.
        switch(arg) {
            case "Item":
                item = new Item();
                break;
            default: break;
        }

        return item;
    }
}
