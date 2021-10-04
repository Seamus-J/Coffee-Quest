package com.CoffeeQuest;

import java.util.*;

public class Main {

    public static void main(String[] args)
	{
        //Create item objects
        Hammer hammer = new Hammer();
        Key key = new Key();
        Flashlight flashlight = new Flashlight();

        //Add items to the Main Room
        List<Items> mainRoomItems = new ArrayList<Items>();
        mainRoomItems.add(hammer);
        mainRoomItems.add(hammer);
        mainRoomItems.add(key);
        CoffeeQuest.mainRoom.setMainRoomItems(mainRoomItems);

        //Add items to Concurrency Room
        List<Items> concurrencyItems = new ArrayList<Items>();
        concurrencyItems.add(hammer);
        concurrencyItems.add(flashlight);
        concurrencyItems.add(key);
        CoffeeQuest.concurrencyRoom.setConcurrencyItems(concurrencyItems);

        //Add items to Exception Room
        List<Items> exceptionItems = new ArrayList<Items>();
        exceptionItems.add(hammer);
        exceptionItems.add(flashlight);
        exceptionItems.add(key);
        CoffeeQuest.exceptionRoom.setExceptionRoomItems(exceptionItems);

        //Add items to InfiniteLoop Room
        List<Items> infiniteLoopItems = new ArrayList<Items>();
        infiniteLoopItems.add(hammer);
        infiniteLoopItems.add(flashlight);
        infiniteLoopItems.add(key);
        CoffeeQuest.infiniteLoopRoom.setInfiniteLoopItems(infiniteLoopItems);


		CoffeeQuest cfq = new CoffeeQuest();
    }
}
