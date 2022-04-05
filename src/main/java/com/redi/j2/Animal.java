package com.redi.j2;

public abstract class Animal {

    private final BloodType bloodType;

    public BloodType getBloodType() {
        return bloodType;
    }

    public Animal(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public abstract void eat();

    public abstract void makeNoise();
}
