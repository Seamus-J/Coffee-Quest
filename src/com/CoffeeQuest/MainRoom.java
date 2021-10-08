package com.CoffeeQuest;

import java.util.List;

/** Represents the main room.
 * @author Seamus Johnson
 * @since 1.0
 */
public class MainRoom extends Rooms
{

    // A list of items in the room
    private List<Items> mainRoomItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    /**
     * gets the name of the room
     * @return string
     */
    @Override
    public String getName(){
        // Name of the room
        return "Main Room";
    }

    /**
     * gets the list of items in the room
     * @return list of items
     */
    @Override
    public List<Items> getItems(){
        return this.mainRoomItems;
    }

    /**
     * gets the description of the room when entered
     * @return string
     */
    @Override
    public String getDescription(){
        // Description given to player of the room
        return "\nYou look around, dazed and confused. The room is damp and dim.\n" +
                    "'Where am I?' You take a look around and see 4 different pathways around you each in a different direction.\n" +
                    "One to the north, one to the east, one to the south, and one to the west.\n" +
                    "'I have to get out of here, where should I go first?'\n";
    }

    /**
     * gets the boolean completion status of the room
     * @return boolean
     */
    @Override
    public boolean GetCompletion() {
        return this.complete;
    }

    /**
     * sets the boolean completion status of the room
     * @param b bool the completion status will be set to
     */
    @Override
    void IsCompletion(boolean b) {
        this.complete = b;
    }

    /**
     * sets the list of items in the room
     * @param mainRoomItems
     */
    public void setMainRoomItems(List<Items> mainRoomItems) {
        this.mainRoomItems = mainRoomItems;
    }
}
