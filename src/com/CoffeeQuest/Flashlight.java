package com.CoffeeQuest;

/** Represents a flashlight.
 * @author Jared W
 * @since 1.0
 */
 public class Flashlight extends Items{

    private final String itemName = "flashlight";
    private final String desc = "This flashlight can be used to give visibility in dark areas.";

     @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    String useItemDescription() {
        return "\nYou switch on your flashlight, only to reveal you are surrounded by mirrors. Nothing seems to end\n" +
                "in this room. How can I BREAK this cycle???";
    }

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
