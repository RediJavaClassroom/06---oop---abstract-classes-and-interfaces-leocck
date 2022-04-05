package com.redi.j2;

import java.util.Random;

public class Dog extends Mammal implements Swimmer, Viviparous {

    public Dog() {

    }

    @Override
    public void eat() {
        System.out.println("This bone is delicious");
    }

    @Override
    public void makeNoise() {
        System.out.println("woof woof");
    }

    @Override
    public void walk() {
        System.out.println("walking");
    }

    @Override
    public void swim() {
        System.out.println("swimming");
    }

    @Override
    public int getMaxBabies() {
        return 24;
    }

    @Override
    public int giveBirth() {
        Random rn = new Random();
        return rn.nextInt(getMaxBabies())+1;
    }
}
