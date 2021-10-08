package com.CoffeeQuest;

/** The abstract class used to base all items off of.
 * @author Alex
 * @since 1.0
 */
public abstract class Items {

    // Method to pull the name of the item
    abstract String getName();

    //Method to pull the description of the item
    abstract String getDescription();

    //Method to pull the 'use item' description of the item
    abstract String useItemDescription();
}
