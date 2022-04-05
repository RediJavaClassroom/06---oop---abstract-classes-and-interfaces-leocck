package com.redi.j2;

public abstract class Mammal extends Animal implements Walker {

    public Mammal() {
        super(BloodType.WARM);
    }

    public void breastfeed() {
        System.out.println("breastfeeding");
    }
}
