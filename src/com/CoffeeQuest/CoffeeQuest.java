package com.CoffeeQuest;

import java.util.List;

public class CoffeeQuest {

    public static ConcurrencyRoom concurrencyRoom = new ConcurrencyRoom();
    public static  ExceptionRoom exceptionRoom = new ExceptionRoom();
    public static FinalExamRoom finalExamRoom = new FinalExamRoom();
    public static InfiniteLoopRoom infiniteLoopRoom = new InfiniteLoopRoom();
    public static MainRoom mainRoom = new MainRoom();
    Player player = new Player(mainRoom);


}
