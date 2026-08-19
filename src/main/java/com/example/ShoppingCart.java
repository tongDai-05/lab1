package com.example;

import java.util.List;

public class ShoppingCart {

    public double calculateTotal(List<Double> prices, boolean isMember) {
        double total = 0;

        for (double price : prices) {
            total += price;
        }

        if (isMember && total >= 100) {
            total *= 0.9;
        } else if (total >= 200) {
            total *= 0.95;
        }

        return total;
    }
}