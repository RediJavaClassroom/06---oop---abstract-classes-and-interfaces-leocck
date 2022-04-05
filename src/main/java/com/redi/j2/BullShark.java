package com.redi.j2;

import java.util.Random;

public class BullShark extends Fish implements Viviparous {

    @Override
    public void eat() {
        System.out.println("This human is delicious");
    }

    @Override
    public void swim() {
        System.out.println("swimming");
    }

    @Override
    public int getMaxBabies() {
        return 13;
    }

    @Override
    public int giveBirth() {
        Random rn = new Random();
        return rn.nextInt(getMaxBabies())+1;
    }
}