package com.example.demo.DIP;

public class FixedDiscountPolicy implements DiscountPolicy{
    private int discountPrice; // 5000

    public FixedDiscountPolicy(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public int discount(int price) {
        return price - discountPrice;
    }
}
