package com.CoffeeQuest;

public class Item extends Items {
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
