package com.redi.j2;

import java.util.Random;

public class Salmon extends Fish implements Oviparous {

    private boolean hasLaidEggs = false;

    @Override
    public void eat() {
        System.out.println("This small pray is delicious");
    }

    @Override
    public void swim() {
        System.out.println("swimming");
    }

    @Override
    public int getMaxEggs() {
        if (!hasLaidEggs) {
            return 2800;
        }
        return 0;
    }

    @Override
    public int layEggs() {
        if (!hasLaidEggs) {
            hasLaidEggs = true;
            Random rn = new Random();
            return rn.nextInt(2800)+1;
        }
        return 0;
    }
}
