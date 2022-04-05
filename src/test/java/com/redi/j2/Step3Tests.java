package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.BullShark;
import com.redi.j2.proxies.Fish;
import com.redi.j2.proxies.Salmon;
import com.redi.j2.proxies.CatShark;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Step3Tests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream setUpStream() {
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    void task_3_1_0_shouldCreateTheFishClass() {

        // given - the class we want the students to implement
        Fish f = Fixtures.createFish();

        // when - we check if it exists

        // then - it should exist
        assertTrue(f.existsClass(), "Fish class is not defined");
    }

    @Test
    void task_3_1_1_shouldExtendAnimal() {

        // given - the class we want the students to implement
        Fish f = Fixtures.createFish();

        // when - we check if it extends the Animal class

        // then - it should
        assertTrue(f.extendsClass("com.redi.j2.Animal"), "Fish class must extend from Animal");

        // and - it should be abstract
        assertTrue(f.isAbstract(), "Class Fish must be abstract");
    }

    @Test
    void task_3_1_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Fish f = Fixtures.createFish();

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(f.hasConstructor(), "Class Fish must have a constructor that receives an int as a parameter");

        // and - it should have set the blood type to 'COLD'
        assertEquals(BloodType.COLD, f.getBloodType(), "Blood Type is not being set to COLD. Please call the constructor from the superclass with the right parameter.");
    }

    @Test
    void task_3_1_3_shouldOverrideMakeNoiseMethod() {

        // given - the class we want the students to implement
        Fish f = Fixtures.createFish();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        f.makeNoise();

        // then - it should print what is expected in the output
        assertEquals("glub glub", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_3_2_0_shouldCreateTheSalmonClass() {

        // given - the class we want the students to implement
        Salmon s = Fixtures.createSalmon();

        // when - we check if it exists

        // then - it should exist
        assertTrue(s.existsClass(), "Salmon class is not defined");
    }

    @Test
    void task_3_2_1_shouldExtendFish() {

        // given - the class we want the students to implement
        Salmon s = Fixtures.createSalmon();

        // when - we check if it extends the Fish class

        // then - it should
        assertTrue(s.extendsClass("com.redi.j2.Fish"), "Salmon class must extend from Fish");
    }

    @Test
    void task_3_2_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Salmon d = Fixtures.createSalmon();

        // when - we check if the default constructor exists

        // then - it should exist
        assertTrue(d.hasConstructor(), "Class Salmon must have a default (no-param) constructor");
    }

    @Test
    void task_3_2_3_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Salmon d = Fixtures.createSalmon();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        d.eat();

        // then - it should print what is expected in the output
        assertEquals("This small pray is delicious", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_3_3_0_shouldCreateTheCatSharkClass() {

        // given - the class we want the students to implement
        CatShark c = Fixtures.createCatShark();

        // when - we check if it exists

        // then - it should exist
        assertTrue(c.existsClass(), "CatShark class is not defined");
    }

    @Test
    void task_3_3_1_shouldExtendFish() {

        // given - the class we want the students to implement
        CatShark c = Fixtures.createCatShark();

        // when - we check if it extends the Fish class

        // then - it should
        assertTrue(c.extendsClass("com.redi.j2.Fish"), "CatShark class must extend from Fish");
    }

    @Test
    void task_3_3_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        CatShark c = Fixtures.createCatShark();

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(c.hasConstructor(), "Class CatShark must have a default constructor");
    }

    @Test
    void task_3_3_3_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        CatShark c = Fixtures.createCatShark();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        c.eat();

        // then - it should print what is expected in the output
        assertEquals("This small fish is delicious", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_3_4_0_shouldCreateTheBullSharkClass() {

        // given - the class we want the students to implement
        BullShark c = Fixtures.createBullShark();

        // when - we check if it exists

        // then - it should exist
        assertTrue(c.existsClass(), "BullShark class is not defined");
    }

    @Test
    void task_3_4_1_shouldExtendFish() {

        // given - the class we want the students to implement
        BullShark c = Fixtures.createBullShark();

        // when - we check if it extends the Fish class

        // then - it should
        assertTrue(c.extendsClass("com.redi.j2.Fish"), "BullShark class must extend from Fish");
    }

    @Test
    void task_3_4_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        BullShark c = Fixtures.createBullShark();

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(c.hasConstructor(), "Class BullShark must have a default constructor");
    }

    @Test
    void task_3_4_3_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        BullShark c = Fixtures.createBullShark();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        c.eat();

        // then - it should print what is expected in the output
        assertEquals("This human is delicious", out.toString().trim(), "The method should print the correct message");
    }
}
