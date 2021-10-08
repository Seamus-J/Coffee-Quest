package com.CoffeeQuest;

/** Represents a battery.
        * @author Seamus Johnson
        * @since 1.0
        */
public class Battery extends Items{
    private final String itemName = "battery";
    private final String desc = "This could power an entire block of houses";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    String useItemDescription() {
        return "\nYou connect the battery to the generators. The lights stop flickering and the humming becomes constant.\n" +
                "It feels oddly soothing. 'There's nothing more for me here' you tell yourself";
    }

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}

