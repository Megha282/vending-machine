package com.vendingmachine.exceptions;

public class OutOfStockException extends Exception{

    public OutOfStockException(final String message){
        super(message);
    }
}
