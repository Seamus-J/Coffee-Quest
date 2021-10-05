package com.CoffeeQuest;

public class KitKat extends Items{
    private final String itemName = "kitkat";
    private final String desc = "Give me a BREAK of that KitKat bar";

    @Override
    String getName() {return itemName;}

    @Override
    String getDescription() {return desc;}

    @Override
    String useItemDescription() {
        return "You eat the kitkat to calm your nerves. As you BREAK yourself off a piece of that kitkat bar\n" +
                "the room suddenly becomes quiet. You're confused, but hey if it did the trick. 'Nothing else to see here.'";
    }

    @Override
    public String toString() {
        return itemName  + ": " + desc;
    }
}
