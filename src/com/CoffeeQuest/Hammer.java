package com.CoffeeQuest;

/** Represents a hammer.
 * @author Jared W
 * @since 1.0
 */
//2.3--Example of the Singleton Pattern
public class Hammer extends Items{

    private static Hammer hammer = null;

    private final String itemName = "hammer";
    private final String desc = "This tool could be useful for smashing";

    /**
     * hammer constructor
     */
    private Hammer() {
    }

    /**
     * gets the instance of a hammer
     * @return hammer
     */
    public static Hammer getInstance()
    {
        if(hammer == null)
        {
            hammer = new Hammer();
        }
        return hammer;
    }

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
     * gets the description of the item
     * @return string
     */
    @Override
    public String useItemDescription() {
        return "\nYou start swinging the hammer violently at all of the mirrors. Glass goes flying everywhere.\n" +
                "You hear the echo begin to fade away. With glass covering the floor, you have finally broken the loop.\n" +
                "'Finally, I can go now.'";
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
