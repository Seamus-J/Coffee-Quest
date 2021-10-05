package com.CoffeeQuest;

import java.util.*;

public class Main {

    public static void main(String[] args)
	{
        //Create item objects
        Hammer hammer = new Hammer();
        Flashlight flashlight = new Flashlight();
        KitKat kitKat = new KitKat();
        Poison poison = new Poison();
        Battery battery = new Battery();

        //Add items to the Main Room
        List<Items> mainRoomItems = new ArrayList<Items>();
        mainRoomItems.add(flashlight);
        mainRoomItems.add(kitKat);
        CoffeeQuest.mainRoom.setMainRoomItems(mainRoomItems);

        //Add items to Concurrency Room
        List<Items> concurrencyItems = new ArrayList<Items>();
        concurrencyItems.add(hammer);
        CoffeeQuest.concurrencyRoom.setConcurrencyItems(concurrencyItems);

        //Add items to Exception Room
        List<Items> exceptionItems = new ArrayList<Items>();
        exceptionItems.add(battery);
        CoffeeQuest.exceptionRoom.setExceptionRoomItems(exceptionItems);

        //Add items to InfiniteLoop Room
        List<Items> infiniteLoopItems = new ArrayList<Items>();
        infiniteLoopItems.add(poison);
        CoffeeQuest.infiniteLoopRoom.setInfiniteLoopItems(infiniteLoopItems);

        CoffeeQuest cfq = new CoffeeQuest();

        // Take player input
        cfq.player.input();
    }
}
