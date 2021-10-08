package com.CoffeeQuest;

public abstract class Item extends Items {
    private String itemName;
    private String desc;
    @Override
    String getName() {
        return itemName;
    }

    @Override
    String getDescription() {
        return desc;
    }
}
