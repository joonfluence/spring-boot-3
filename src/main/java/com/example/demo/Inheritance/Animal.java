package com.example.demo.Inheritance;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void breathe(){
        System.out.println("숨을 쉽니다");
    }

    public void eat(){
        System.out.println("음식을 먹는다");
    }
}
