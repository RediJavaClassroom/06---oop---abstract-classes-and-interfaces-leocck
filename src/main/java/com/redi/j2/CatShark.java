package com.redi.j2;

import java.util.Random;

public class CatShark extends Fish implements Oviparous {

    @Override
    public void eat() {
        System.out.println("This small fish is delicious");
    }

    @Override
    public void swim() {
        System.out.println("swimming");
    }

    @Override
    public int getMaxEggs() {
        return 20;
    }

    @Override
    public int layEggs() {
        Random rn = new Random();
        return rn.nextInt(getMaxEggs())+1;
    }
}
