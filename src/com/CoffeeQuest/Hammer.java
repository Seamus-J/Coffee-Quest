package com.CoffeeQuest;

public class Hammer extends Items{
    private final String itemName = "hammer";
    private final String desc = "This tool could be useful for smashing";


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
