package org.example;

import org.example.customExceptions.WrongBuyerException;
import org.example.customExceptions.WrongItemException;
import org.example.customExceptions.WrongQuantityException;
import org.example.onlineStoreObjects.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnlineOrders {
    private static List<Integer> buyers = new ArrayList<>();
    private static List<String> items = new ArrayList<String>();
    public static List<Order> orders = new ArrayList<Order>();

    static {
        buyers.add(1);
        buyers.add(2);
        buyers.add(3);

        items.add("apples");
        items.add("oranges");
        items.add("pears");
    }

    public static void makeAPurchase(Order order){
        try{
            if (buyers.indexOf(order.getBuyer().getUserID()) == -1) {
                throw new WrongBuyerException(String.format("Buyer: %s is not existed", order.getBuyer().toString()));
            }
            if (items.indexOf(order.getItem().getItem()) == -1) {
                throw new WrongItemException(String.format("Item: %s is not exist", order.getItem().toString()));
            }
            if (order.getQuantity() <= 0) {
                throw new WrongQuantityException("Quantity can't be 0 or negative");
            }

            orders.add(order);
        } catch (IOException ex){
            System.err.println(ex);
        } catch (ArithmeticException ex) {
            System.err.println(ex);
        }
    }

}
