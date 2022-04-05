package com.redi.j2;

import java.util.Random;

public class Elephant extends Mammal implements Viviparous {

    @Override
    public void eat() {
        System.out.println("This hay is delicious");
    }

    @Override
    public void makeNoise() {
        System.out.println("bahruuuuuuhhhhaaaaa");
    }

    @Override
    public void walk() {
        System.out.println("walking");
    }

    @Override
    public int getMaxBabies() {
        return 2;
    }

    @Override
    public int giveBirth() {
        Random rn = new Random();
        return rn.nextInt(getMaxBabies())+1;
    }
}
