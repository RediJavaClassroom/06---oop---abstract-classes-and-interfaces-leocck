package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Animal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Step1Tests {

    @Test
    void task_1_1_shouldCreateTheAnimalClass() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // when - we check if it exists

        // then - it should exist
        assertTrue(a.existsClass(), "Animal class is not defined");

        // and - it should be abstract
        assertTrue(a.isAbstract(), "Class Animal must be abstract");
    }

    @Test
    void task_1_2_shouldHaveBloodTypeProperty() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // when - we check if the bloodType property exists

        // then - it should exist
        assertTrue(a.hasProperty("bloodType"), "Variable 'bloodType' is not defined");

        // and - it should be of type int
        assertTrue(a.isPropertyOfType("bloodType", BloodType.class), "Variable 'bloodType' is not of type BloodType");

        // and - it should be final
        assertTrue(a.isPropertyPrivate("bloodType"), "Variable 'bloodType' must be private");

        // and - it should be final
        assertTrue(a.isPropertyFinal("bloodType"), "Variable 'bloodType' must be final");
    }

    @ParameterizedTest
    @EnumSource(BloodType.class)
    void task_1_3_shouldHaveParameterizedConstructor(BloodType bloodType) {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal(bloodType);

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(a.hasConstructor(BloodType.class), "Class Animal must have a constructor that receives the BloodType as a parameter");

        // and - it should set the attribute to the proper value
        assertEquals(bloodType, a.getBloodType(), "Variable 'bloodType' is not initialized properly inside the constructor");
    }

    @Test
    void task_1_4_shouldCreateGetBloodTypeMethod() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // when - we check if the getter is correctly implemented

        // then - it should exist
        assertTrue(a.hasMethod("getBloodType"), "Property 'bloodType' must have a getter called 'getBloodType'");
        assertTrue(a.isMethodReturnType(BloodType.class, "getBloodType"), "Method 'getBloodType' must return BloodType");
    }

    @Test
    void task_1_5_shouldDefineEatMethod() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // when - we check if the getter is correctly implemented

        // then - it should exist and be configured properly
        assertTrue(a.hasMethod("eat"), "Method 'eat' must be defined");
        assertTrue(a.isMethodReturnType(void.class, "eat"), "Method 'eat' must return void");
        assertTrue(a.isMethodAbstract("eat"), "Method 'eat' must be abstract");
    }

    @Test
    void task_1_6_shouldDefineMakeNoiseMethod() {

        // given - the class we want the students to implement
        Animal a = Fixtures.createAnimal();

        // when - we check if the getter is correctly implemented

        // then - it should exist and be configured properly
        assertTrue(a.hasMethod("makeNoise"), "Method 'makeNoise' must be defined");
        assertTrue(a.isMethodReturnType(void.class, "makeNoise"), "Method 'makeNoise' must return void");
        assertTrue(a.isMethodAbstract("makeNoise"), "Method 'makeNoise' must be abstract");
    }
}
