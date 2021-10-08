package com.CoffeeQuest;

public class IncorrectFileNameException extends Exception{
    public IncorrectFileNameException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
