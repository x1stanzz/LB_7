package org.example.Exceptions;

public class OutOfStockException extends Exception{
    public OutOfStockException(String message){
        super(message);
    }
}
