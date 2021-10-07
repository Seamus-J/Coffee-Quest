package com.CoffeeQuest;

import java.util.List;

public class MainRoom extends Rooms
{
    // Name of the room
    private final String name = "Main Room";

    // A list of items in the room
    private List<Items> mainRoomItems;

    // Boolean to keep record of whether the player has completed to room
    private boolean complete = false;

    // Description given to player of the room
    private final String description = "\nYou look around, dazed and confused. The room is damp and dim.\n" +
            "'Where am I?' You take a look around and see 4 different pathways around you each in a different direction.\n" +
            "One to the north, one to the east, one to the south, and one to the west.\n" +
            "'I have to get out of here, where should I go first?'\n";

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List<Items> getItems(){
        return this.mainRoomItems;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public boolean GetCompletion() {
        return this.complete;
    }

    @Override
    void IsCompletion(boolean b) {
        this.complete = b;
    }

    public List<Items> getMainRoomItems() {
        return mainRoomItems;
    }

    public void setMainRoomItems(List<Items> mainRoomItems) {
        this.mainRoomItems = mainRoomItems;
    }
}
