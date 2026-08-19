package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    private final ShoppingCart cart = new ShoppingCart();

    @Test
    void testMemberDiscount() {
        double result = cart.calculateTotal(
                Arrays.asList(50.0, 70.0),
                true
        );

        assertEquals(108.0, result, 0.001);
    }

    @Test
    void testNonMemberDiscount() {
        double result = cart.calculateTotal(
                Arrays.asList(100.0, 150.0),
                false
        );

        assertEquals(237.5, result, 0.001);
    }

    @Test
    void testNoDiscount() {
        double result = cart.calculateTotal(
                Collections.singletonList(50.0),
                false
        );

        assertEquals(50.0, result, 0.001);
    }
}