package com.CoffeeQuest;

/** Represents the commands the player is able to make.
 * @author Billy R
 * @since 1.0
 */
public class Commands {

    private final String[] commands = {"help", "move", "talk", "pickup", "use", "drop", "quit", "look"};
    private final String[] commandDescription = {"Get this list", "Move to the selected room(north, south, east, west)",
            "Talk to an NPC", "Pickup an item", "Use a selected Item", "Drop an item", "Quit the game", "Gives brief description of surroundings"};

    /**
     * Method to list commands available to the player
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
        System.out.println(" ");
    }

    /**
     *Method to quit the game
     */
    public void quit() {
        System.out.println("Quitting game....");
        System.exit(0);
    }

    /**
     * This method is used to get an instance of an item
     * @param arg the argument command from player input
     * @return Items returns the selected item
     */
    public Items getItem(String arg) {
        Items item = null;
        // Return the class of Item used to pickup, drop, or use.
        switch(arg) {
            case "battery":
                item = new Battery();
                break;
            case "hammer":
                item = Hammer.getInstance();
                break;
            case "flashlight":
                item = new Flashlight();
                break;
            case "kitkat":
                item = new KitKat();
                break;
            case "poison":
                item = new Poison();
                break;
            default: break;
        }
        return item;
    }
}
