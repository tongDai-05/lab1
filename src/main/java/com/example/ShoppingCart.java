package com.example;

import java.util.List;

public class ShoppingCart {

    public double calculateTotal(List<Double> prices, boolean isMember) {
        // 1. Xử lý danh sách null hoặc rỗng
        if (prices == null || prices.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (double price : prices) {
            // 2. Kiểm tra giá không hợp lệ
            if (price <= 0) {
                throw new IllegalArgumentException("Giá sản phẩm phải lớn hơn 0");
            }
            total += price;
        }

        // 3. Áp dụng giảm giá
        if (isMember) {
            if (total > 100.0) {
                total = total * 0.9; // Giảm 10%
            }
        } else {
            if (total > 200.0) {
                total = total * 0.95; // Giảm 5%
            }
        }

        return total;
    }
}