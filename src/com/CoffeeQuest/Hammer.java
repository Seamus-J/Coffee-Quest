package com.CoffeeQuest;

public class Hammer extends Items{
    private final String itemName = "hammer";
    private final String desc = "This tool could be useful for smashing";


    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
