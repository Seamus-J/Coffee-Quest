package com.CoffeeQuest;

/**
 * Represents a battery.
 * @author Seamus Johnson
 * @since 1.0
 */
public class Battery extends Items{
    private final String itemName = "battery";
    private final String desc = "This could power an entire block of houses";

    /**
     * the name of the item
     * @return string name
     */
    @Override
    public String getName() {return itemName;}

    /**
     * gets the description of the item
     * @return return string
     */
    @Override
    public String getDescription() {return desc;}

    /**
     * gets the item description when the item is used properly
     * @return string
     */
    @Override
    public String useItemDescription() {
        return "\nYou connect the battery to the generators. The lights stop flickering and the humming becomes constant.\n" +
                "It feels oddly soothing. 'There's nothing more for me here' you tell yourself";
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

