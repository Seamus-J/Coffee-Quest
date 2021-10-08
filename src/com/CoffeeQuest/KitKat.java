package com.CoffeeQuest;

/** Represents a kitkat item.
 * @author Seamus Johnson
 * @since 1.0
 */
public class KitKat extends Items{
    private final String itemName = "kitkat";
    private final String desc = "Give me a BREAK of that KitKat bar";

    /**
     * gets the name of the item
     * @return string
     */
    @Override
    String getName() {return itemName;}

    /**
     * gets the description of the item
     * @return string
     */
    @Override
    String getDescription() {return desc;}

    /**
     * gets the description when the item is used properly
     * @return string
     */
    @Override
    String useItemDescription() {
        return "You eat the kitkat to calm your nerves. As you BREAK yourself off a piece of that kitkat bar\n" +
                "the room suddenly becomes quiet. You're confused, but hey if it did the trick. 'Nothing else to see here.'";
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
