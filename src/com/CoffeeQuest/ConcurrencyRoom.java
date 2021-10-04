package com.CoffeeQuest;

import java.util.List;

public class ConcurrencyRoom extends Rooms
{
    // Name of the room
    private final String name = "Concurrency Room";

    // A list of items in the room
    private List<Items> concurrencyItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    @Override
    /**
     * gets the name of the room
     * @return the name of the room
     */
    public String getName(){
        return this.name;
    }

    @Override
    /**
     * gets the list of items in the room
     * @return the list of items
     */
    public List<Items> getItems(){
        return this.getConcurrencyItems();
    }


    @Override
    /**
     * gets the description of the room
     * @return the description
     */
    public String getDescription(){
        // Description given to player of the room
        return "\nYou head towards the tunnel to the south. The tunnel seems to be flashing as if someone was turning on and off a light.\n" +
                "'Is someone down there?' you yell, but there is no response. As you get closer you hear the faint hum of a machine.\n" +
                "You finally reach the wooden door where this all coming from and open the door.\n"+
                "The lights are flickering on and off and there is a loud humming noise \nthat" +
                " seems to pulsing on and off. You see two generators that seem \nto be trying to run at the same" +
                " time, but there doesn't seem to be enough power to \nkeep them both going at once. How can I " +
                "keep these lights?\n";
    }

    @Override
    /**
     * gets the completion status of a room
     * @return the bool of the completion status of the room
     */
    public boolean getCompletion() {
        return this.complete;
    }

    @Override
    /**
     * changes the completion status of a room if the players finds the solution
     * @param b bool the completion status will be set to
     */
    void setCompletion(boolean b) {
        this.complete = b;
    }

    /**
     * Event after the player successfully completes the room challenge
     */
    public void completeRoomChallenge() {
        // TODO How does the player complete this room's challenge
        //  what will happen when the player completes this room
    }

    /**
     * Event after the player fails the room challenge
     */
    public void failRoomChallenge() {
        // TODO How does the player fail this challenge
        //  what will happen if the player fails
    }


    public List<Items> getConcurrencyItems() {
        return concurrencyItems;
    }

    public void setConcurrencyItems(List<Items> concurrencyItems) {
        this.concurrencyItems = concurrencyItems;

    }
}
