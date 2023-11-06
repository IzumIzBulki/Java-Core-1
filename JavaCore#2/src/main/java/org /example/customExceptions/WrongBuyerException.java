package org.example.customExceptions;

import java.io.IOException;

public class WrongBuyerException extends IOException {
    public WrongBuyerException(String message){super(message);}
}
