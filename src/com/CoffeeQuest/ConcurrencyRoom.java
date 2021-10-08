package com.CoffeeQuest;

import java.util.List;

/** Represents a the Concurrency Room.
 * @author Seamus Johnson
 * @since 1.0
 */
public class ConcurrencyRoom extends Rooms
{
    // Name of the room
    private final String name = "Concurrency Room";

    // A list of items in the room
    private List<Items> concurrencyItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List<Items> getItems(){
        return this.getConcurrencyItems();
    }


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

    @Override
    public boolean GetCompletion() {
        return this.complete;
    }

    @Override
    void IsCompletion(boolean b) {
        this.complete = b;
    }

    public List<Items> getConcurrencyItems() {
        return concurrencyItems;
    }

    public void setConcurrencyItems(List<Items> concurrencyItems) {
        this.concurrencyItems = concurrencyItems;

    }
}
