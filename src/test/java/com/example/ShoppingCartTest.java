package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    private final ShoppingCart cart = new ShoppingCart();

    // 1. Đường đi: Thành viên (Member) và tổng tiền > 100 (được giảm giá)
    @Test
    void testMemberDiscount() {
        double result = cart.calculateTotal(
                Arrays.asList(50.0, 70.0), // tổng 120 -> giảm 10% còn 108
                true);
        assertEquals(108.0, result, 0.001);
    }

    // 2. Đường đi: Thành viên (Member) nhưng tổng tiền <= 100 (không giảm giá)
    @Test
    void testMemberNoDiscount() {
        double result = cart.calculateTotal(
                Arrays.asList(30.0, 40.0), // tổng 70 <= 100
                true);
        assertEquals(70.0, result, 0.001);
    }

    // 3. Đường đi: Không phải thành viên (Non-Member) và tổng tiền > 200 (giảm 5%)
    @Test
    void testNonMemberDiscount() {
        double result = cart.calculateTotal(
                Arrays.asList(100.0, 150.0), // tổng 250 -> giảm 5% còn 237.5
                false);
        assertEquals(237.5, result, 0.001);
    }

    // 4. Đường đi: Không phải thành viên và tổng tiền <= ngưỡng giảm giá
    @Test
    void testNoDiscount() {
        double result = cart.calculateTotal(
                Collections.singletonList(50.0),
                false);
        assertEquals(50.0, result, 0.001);
    }

    // 5. Đường đi: Danh sách null
    @Test
    void testNullList() {
        assertEquals(0.0, cart.calculateTotal(null, false));
    }

    // 6. Đường đi: Danh sách rỗng
    @Test
    void testEmptyList() {
        assertEquals(0.0, cart.calculateTotal(Collections.emptyList(), true));
    }

    // 7. Đường đi: Có giá trị <= 0 (ném ngoại lệ)
    @Test
    void testInvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.calculateTotal(Arrays.asList(50.0, -10.0), true);
        });
    }
}