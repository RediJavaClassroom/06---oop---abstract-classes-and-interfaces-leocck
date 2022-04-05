package com.redi.j2;

import java.util.Random;

public class Platypus extends Mammal implements Swimmer, Oviparous {

    public Platypus() {

    }

    @Override
    public void eat() {
        System.out.println("This insect larvae is delicious");
    }

    @Override
    public void makeNoise() {
        System.out.println("gyururururururu");
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
    public int getMaxEggs() {
        return 2;
    }

    @Override
    public int layEggs() {
        Random rn = new Random();
        return rn.nextInt(getMaxEggs())+1;
    }
}
