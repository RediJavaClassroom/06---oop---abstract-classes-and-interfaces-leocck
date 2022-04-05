package com.redi.j2;

public abstract class Fish extends Animal implements Swimmer{

    public Fish() {
        super(BloodType.COLD);
    }

    @Override
    public void makeNoise() {
        System.out.println("glub glub");
    }
}
