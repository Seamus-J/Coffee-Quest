package com.CoffeeQuest;

import java.util.List;

/** Represents the Concurrency Room.
 * @author Seamus Johnson
 * @since 1.0
 */
public class ConcurrencyRoom extends Rooms
{
    // A list of items in the room
    private List<Items> concurrencyItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    /**
     * Gets the name of the room
     * @return string
     */
    @Override
    public String getName(){
        // Name of the room
        return "Concurrency Room";
    }

    /**
     * gets the list of items in the room
     * @return string
     */
    @Override
    public List<Items> getItems(){
        return this.getConcurrencyItems();
    }

    /**
     * gets the description of the room when you enter it
     * @return string
     */
    @Override
    public String getDescription(){
        // Description given to player of the room
        return "\nYou head towards the tunnel to the south. The tunnel seems to be flashing as if someone was turning on and off a light.\n" +
                "'Is someone down there?' you yell, but there is no response. As you get closer you hear the faint hum of a machine.\n" +
                "You finally reach the wooden door where this all coming from and open the door.\n"+
                "The lights are flickering on and off and there is a loud humming noise \nthat" +
                " seems to pulsing on and off. You see two generators that seem \nto be trying to run at the same" +
                " time, but there doesn't seem to be enough power to \nkeep them both going at once. How can I " +
                "keep these lights?          (South Room)\n";
    }

    /**
     * gets the boolean completion status of the room
     * @return bool
     */
    @Override
    public boolean GetCompletion() {
        return this.complete;
    }

    /**
     * set the boolean completino status of the room
     * @param b bool the completion status will be set to
     */
    @Override
    void IsCompletion(boolean b) {
        this.complete = b;
    }

    /**
     * gets the list of items in the room
     * @return list<items>/
     * */
    public List<Items> getConcurrencyItems() {
        return concurrencyItems;
    }

    /**
     * sets the list of items in the room
     *
     */
    public void setConcurrencyItems(List<Items> concurrencyItems) {
        this.concurrencyItems = concurrencyItems;

    }
}
