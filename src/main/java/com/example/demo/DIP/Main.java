package com.example.demo.DIP;

public class Main {

    // 이커머스 개발자 = 기획자 일주일 전, 처음에는 정액(전체 품목에 대해서 5000원 할인) -> 일주일 전 (전체 품목에 대해서 10% 할인 정책)
    public static void main(String[] args) {
        FixedDiscountPolicy fixedDiscountPolicy = new FixedDiscountPolicy(10000);
        DiscountService discountService = new DiscountService(fixedDiscountPolicy);
        System.out.println(discountService.discount(50000));
    }
}
