package com.redi.j2.fixtures;

import com.redi.j2.BloodType;
import com.redi.j2.proxies.*;
import org.mockito.Mockito;

import java.util.Random;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

public class Fixtures {

    public static Animal createAnimal() {
        return createAnimal(BloodType.COLD);
    }

    public static Animal createAnimal(BloodType type) {
        Class<?> clazz = new Animal(type).getTargetClass();
        if(clazz == null) return new Animal(type);
        Object mockTarget = Mockito.mock(
                clazz,
                Mockito.withSettings().useConstructor(type)
                        .defaultAnswer(CALLS_REAL_METHODS)
        );
        return new Animal(mockTarget);
    }

    public static Mammal createMammal() {
        Class<?> clazz = new Mammal().getTargetClass();
        if(clazz == null) return new Mammal();
        try {
            Object mockTarget = Mockito.mock(
                    clazz,
                    Mockito.withSettings().useConstructor()
                            .defaultAnswer(CALLS_REAL_METHODS)
            );
            return new Mammal(mockTarget);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Dog createDog() {
        return new Dog();
    }

    public static Elephant createElephant() {
        return new Elephant();
    }

    public static Platypus createPlatypus() {
        return new Platypus();
    }

    public static Fish createFish() {
        Class<?> clazz = new Fish().getTargetClass();
        if(clazz == null) return new Fish();
        try {
            Object mockTarget = Mockito.mock(
                    clazz,
                    Mockito.withSettings().useConstructor()
                            .defaultAnswer(CALLS_REAL_METHODS)
            );
            return new Fish(mockTarget);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Salmon createSalmon() {
        return new Salmon();
    }

    public static CatShark createCatShark() {
        return new CatShark();
    }

    public static BullShark createBullShark() {
        return new BullShark();
    }

    public static Walker createWalker() {
        return new Walker();
    }

    public static Swimmer createSwimmer() {
        return new Swimmer();
    }

    public static Viviparous createViviparous() {
        return new Viviparous();
    }

    public static Oviparous createOviparous() {
        return new Oviparous();
    }
}
