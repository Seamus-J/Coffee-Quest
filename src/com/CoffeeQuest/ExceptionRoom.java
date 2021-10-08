package com.CoffeeQuest;

import java.util.List;

/** Represents the Exception Room.
 * @author Seamus Johnson
 * @since 1.0
 */
public class ExceptionRoom extends Rooms
{

    // A list of items in the room
    private List<Items> exceptionRoomItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    @Override
    public String getName(){
        // Name of the room
        return "Exception Room";
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
                "\nThere has to be a way to fix this bug problem.        (East Room)\n";
    }

    @Override
    public boolean GetCompletion() {
        return this.complete;
    }

    @Override
    void IsCompletion(boolean b) {
        this.complete = b;
    }

    public void setExceptionRoomItems(List<Items> exceptionRoomItems) {
        this.exceptionRoomItems = exceptionRoomItems;
    }
}
