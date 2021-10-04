package com.CoffeeQuest;

import java.util.*;

public class Main {

    public static void main(String[] args)
	{
        Hammer hammer = new Hammer();
        Key key = new Key();
        Flashlight flashlight = new Flashlight();
        List<Items> list = new ArrayList<Items>();
        list.add(hammer);
        list.add(flashlight);
       list.add(key);

       CoffeeQuest.concurrencyRoom.setConcurrencyItems(list);

		CoffeeQuest cfq = new CoffeeQuest();
    }
}
