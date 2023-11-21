package com.example.demo.Inheritance;

public class Dog extends Animal {
    private String furColor;

    public Dog(String name, int age, String furColor) {
            super(name, age);
            this.furColor = furColor;
        }

        public void bark(){
            System.out.println("강아지가 짖는다");
        }

        public void walk(){
            System.out.println("네발로 걷는다.");
    }
}
