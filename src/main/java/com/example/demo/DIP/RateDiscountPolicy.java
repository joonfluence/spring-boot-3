package com.example.demo.DIP;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountRate;

    public RateDiscountPolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public int discount(int price) {
        return (price * (100 - discountRate)) / 100;
    }
}
