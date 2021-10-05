package com.CoffeeQuest;

public class Poison extends Items{
    private final String itemName = "poison";
    private final String desc = "This could wipe out anything";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    String useItemDescription() {
        return "You spread the poison all over the floor. The bugs quickly begin to die, and those aren't killed\n" +
                " scurry away out of the room. The room becomes completely clear. 'That solves that bug problem.'";
    }

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
