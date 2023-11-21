package com.example.demo.DIP;

public class DiscountService implements DiscountPolicy {
    private final DiscountPolicy discountPolicy;

    public DiscountService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public int discount(int money){
        return discountPolicy.discount(money);
    }
}
