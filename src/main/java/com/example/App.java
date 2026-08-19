package com.example;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        double total = cart.calculateTotal(
                Arrays.asList(50.0, 70.0),
                true);

        System.out.println("Total: " + total);
    }
}