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

    private Hammer() {
    }

    public static Hammer getInstance()
    {
        if(hammer == null)
        {
            hammer = new Hammer();
        }
        return hammer;
    }

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    String useItemDescription() {
        return "\nYou start swinging the hammer violently at all of the mirrors. Glass goes flying everywhere.\n" +
                "You hear the echo begin to fade away. With glass covering the floor, you have finally broken the loop.\n" +
                "'Finally, I can go now.'";
    }

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
