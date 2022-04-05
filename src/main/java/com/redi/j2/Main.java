package com.redi.j2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // The Animal Kingdom list
        List<Animal> animalKingdom = new ArrayList<>();
        // Adding some animals
        animalKingdom.add(new Dog());
        animalKingdom.add(new Elephant());
        animalKingdom.add(new Platypus());
        animalKingdom.add(new Salmon());
        animalKingdom.add(new CatShark());
        animalKingdom.add(new BullShark());
        // printing information from all animals
        for (Animal animal : animalKingdom) {

            System.out.println("----------------------------------");
            // gets the name of the most specific class type
            String className = animal.getClass().getSimpleName();
            System.out.println(className.toUpperCase());
            // printing some information from Animal class
            System.out.println("Blood: " + animal.getBloodType());
            System.out.print("Sound: ");
            animal.makeNoise();
            System.out.print("Eat: ");
            animal.eat();
            // printing extra information from extended classes
            if (animal instanceof Mammal) {
                Mammal m = (Mammal) animal;
                System.out.print("Breastfeed: ");
                m.breastfeed();
            }
            // printing extra information from interfaces
            if (animal instanceof Walker) {
                Walker w = (Walker) animal;
                System.out.print("Walk: ");
                w.walk();
            }
            if (animal instanceof Swimmer) {
                Swimmer s = (Swimmer) animal;
                System.out.print("Swim: ");
                s.swim();
            }
            if (animal instanceof Oviparous) {
                Oviparous o = (Oviparous) animal;
                System.out.println("Max Eggs: " + o.getMaxEggs());
                System.out.println("Lay Eggs generated: "+o.layEggs()+" eggs");
            }
            if (animal instanceof Viviparous) {
                Viviparous v = (Viviparous) animal;
                System.out.println("Max Babies: " + v.getMaxBabies());
                System.out.println("Give Birth generated: "+v.giveBirth()+" children");
            }
        }
        System.out.println("----------------------------------");
    }
}
