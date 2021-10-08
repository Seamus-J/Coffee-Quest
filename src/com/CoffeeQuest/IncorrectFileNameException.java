package com.CoffeeQuest;

/** This is a custom exception used to throw when an incorrect file is found
 * @author Seamus Johnson
 * @since 1.0
 */
public class IncorrectFileNameException extends Exception{
    public IncorrectFileNameException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
}
