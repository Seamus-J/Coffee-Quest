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

    @Override
    public String getName(){
        // Name of the room
        return "Main Room";
    }

    @Override
    public List<Items> getItems(){
        return this.mainRoomItems;
    }

    @Override
    public String getDescription(){
        // Description given to player of the room
        return "\nYou look around, dazed and confused. The room is damp and dim.\n" +
                    "'Where am I?' You take a look around and see 4 different pathways around you each in a different direction.\n" +
                    "One to the north, one to the east, one to the south, and one to the west.\n" +
                    "'I have to get out of here, where should I go first?'\n";
    }

    @Override
    public boolean GetCompletion() {
        return this.complete;
    }

    @Override
    void IsCompletion(boolean b) {
        this.complete = b;
    }

    public void setMainRoomItems(List<Items> mainRoomItems) {
        this.mainRoomItems = mainRoomItems;
    }
}
