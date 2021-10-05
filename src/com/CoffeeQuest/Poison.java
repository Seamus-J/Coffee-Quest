package com.CoffeeQuest;

public class Poison extends Items{
    private final String itemName = "Poison";
    private final String desc = "This could wipe out anything";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
