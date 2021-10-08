package com.CoffeeQuest;

public abstract class Key extends Items{
    private final String itemName = "key";
    private final String desc = "Keys can be used to open locks.";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
