package com.CoffeeQuest;

/** Represents a flashlight.
 * @author Jared W
 * @since 1.0
 */
 public class Flashlight extends Items{

     // item name
    private final String itemName = "flashlight";

    // item description
    private final String desc = "This flashlight can be used to give visibility in dark areas.";

    /**
     * gets the name of the item
     * @return string
     */
     @Override
    public String getName() {return itemName;}

    /**
     * gets the description of the item
     * @return string
     */
    @Override
    public String getDescription() {return desc;}

    /**
     * gets the description of the item when used properly
     * @return string
     */
    @Override
    public String useItemDescription() {
        return "\nYou switch on your flashlight, only to reveal you are surrounded by mirrors. Nothing seems to end\n" +
                "in this room. How can I BREAK this cycle???";
    }

    /**
     * toString override
     * @return string
     */
    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
