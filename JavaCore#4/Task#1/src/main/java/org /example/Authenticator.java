package org.example;
import org.example.customExceptions.*;

import java.io.IOException;

public class Authenticator {
    public static boolean checker(String login, String password, String confirmPassword){
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException("Your login is less than 20 symbols");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Your password and confirm password is not the same");
            }
            System.out.println("You have successfully registered!");
            return true;
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
