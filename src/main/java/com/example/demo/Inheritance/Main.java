package com.example.demo.Inheritance;

import com.example.demo.Inheritance.Animal;
import com.example.demo.Inheritance.Dog;
import com.example.demo.Inheritance.Human;

public class Main {

    public static void main(String[] args) {
        Animal human2 = new Human("지수", 22);
        Animal dog2 = new Dog("말티즈", 8, "갈색");

        // Animal 객체를 Animal, Human, Dog = 다형성

        Human human = new Human("홍길동", 20);
        Dog dog = new Dog("포메", 10, "갈색");

        dog.bark();
        dog.walk();
        dog.breathe();

        System.out.println("------");

        human.speak();
        human.breathe();
        human.walk();
    }


}
