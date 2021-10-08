package com.CoffeeQuest;

/** Represents a poison object.
 * @author Seamus Johnson
 * @since 1.0
 */
public class Poison extends Items{
    private final String itemName = "poison";
    private final String desc = "This could wipe out anything";

    /**
     * gets the name of the item
     * @return string
     */
    @Override
    String getName() {return itemName;}

    /**
     * gets the description of the item
     * @return string
     */
    @Override
    String getDescription() {return desc;}

    /**
     * gets the description when the item is used properly
     * @return string
     */
    @Override
    String useItemDescription() {
        return "You spread the poison all over the floor. The bugs quickly begin to die, and those aren't killed\n" +
                " scurry away out of the room. The room becomes completely clear. 'That solves that bug problem.'";
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
