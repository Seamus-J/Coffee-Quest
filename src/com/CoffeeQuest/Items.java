package com.CoffeeQuest;

/** The abstract class used to base all items off of.
 * @author Alex
 * @since 1.0
 */
public abstract class Items {

    /**
     * gets the name of the item
     * @return string
     */
    abstract String getName();

    /**
     * gets the description of the item
     * @return string
     */
    abstract String getDescription();

    /**
     * gets the description when item is used properly
     * @return string
     */
    abstract String useItemDescription();
}
