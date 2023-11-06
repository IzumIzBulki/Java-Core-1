package org.example.customExceptions;

public class WrongItemException extends ArithmeticException{
    public WrongItemException(String message){
        super(message);
    }
}
