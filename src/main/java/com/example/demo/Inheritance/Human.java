package com.example.demo.Inheritance;

public class Human extends Animal {

    public Human(String name, int age) {
        super(name, age);
    }

    public void speak(){
        System.out.println("사람이 말한다");
    }

    public void walk(){
        System.out.println("두발로 걷는다.");
    }
}
