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

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List<Items> getItems(){
        return this.exceptionRoomItems;
    }

    @Override
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
    public boolean GetCompletion() {
        return this.complete;
    }

    @Override
    void IsCompletion(boolean b) {
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
