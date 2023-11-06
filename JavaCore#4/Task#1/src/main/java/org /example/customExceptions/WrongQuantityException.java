package org.example.customExceptions;

import java.io.IOException;

public class WrongQuantityException extends IOException {
    public WrongQuantityException (String message){
        super(message);
    }
}
