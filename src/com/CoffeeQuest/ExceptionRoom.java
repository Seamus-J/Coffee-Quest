package com.CoffeeQuest;

import java.util.List;

public class ExceptionRoom extends Rooms
{
    // Name of the room
    private final String name = "Exception Room";

    // A list of items in the room
    private List<Items> items;

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
        return this.items;
    }

    @Override
    /**
     * gets the description of the room
     * @return the description
     */
    public String getDescription(){
        // Description given to player of the room
        return "\nYou head down a path covered in spider webs.\n" +
                "'I hate bugs' you say to yourself\n" +
                "You can barely see but you navigate your through. 'It seems like the walls moving.'" +
                "You reach the end and go through the doorway."+
                "As you step into the room, you hear a crunch under your feet. " +
                "What was that? \nYou look down only to see bugs crawling all over you feet! \n'AHHH' You shake them " +
                "off and think about running out of the door, but you stay calm. \n" +
                "\nThere has to be a way to fix this bug problem.\n";
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
}
