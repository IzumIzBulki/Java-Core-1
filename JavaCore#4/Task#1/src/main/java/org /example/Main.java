package org.example;

import org.example.onlineStoreObjects.Order;

public class Main {

    enum Color {
        RED("#FF0000"), GREEN("#00FF00");
        private String code;
        Color(String code){
            this.code = code;
        }

        public String getCode() {return code;}
    }

    public static void main(String[] args) {

        // 1. Задача: Проверка логина и пароля
        Authenticator.checker("login1", "pass", "pass");
        Authenticator.checker("login1", "pass", "pass1");
        Authenticator.checker("login1;ljasfalsjfasfasfasfa", "pass", "pass");

        // 2. Задача: Эмуляция интернет-магазина
        Order order1 = new Order(1, "apples", 1);
        Order order2 = new Order(4, "apples", 1);
        Order order3 = new Order(1, "watermelon", 1);
        Order order4 = new Order(1, "apples", 0);

        OnlineOrders.makeAPurchase(order1);
        OnlineOrders.makeAPurchase(order2);
        OnlineOrders.makeAPurchase(order3);
        OnlineOrders.makeAPurchase(order4);

        for (Order order: OnlineOrders.orders) {
            System.out.println(order.toString());
        }
    }
}
