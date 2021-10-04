package com.CoffeeQuest;

import java.util.List;

public class ExceptionRoom extends Rooms
{
    // Name of the room
    private final String name = "Exception Room";

    // A list of items in the room
    private List<Items> exceptionRoomItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    // Description given to player of the room
    private final String description = "As you step into the room, you hear a crunch under your feet. " +
            "What was that? \nYou look down only to see bugs crawling all over you feet! \n'AHHH' You shake them " +
            "off and try to run out of the door, but the door has \nlocked behind you. \n'How do I get out of here?!'" +
            "\nThere has to be a way to fix this bug problem.\n";

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
        return this.exceptionRoomItems;
    }

    @Override
    /**
     * gets the description of the room
     * @return the description
     */
    public String getDescription(){
        return this.description;
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
    void completeRoomChallenge() {
        // TODO How does the player complete this room's challenge
        //  what will happen when the player completes this room
    }

    /**
     * Event after the player fails the room challenge
     */
    void failRoomChallenge() {
        // TODO How does the player fail this challenge
        //  what will happen if the player fails
    }

    public List<Items> getExceptionRoomItems() {
        return exceptionRoomItems;
    }

    public void setExceptionRoomItems(List<Items> exceptionRoomItems) {
        this.exceptionRoomItems = exceptionRoomItems;
    }
}
