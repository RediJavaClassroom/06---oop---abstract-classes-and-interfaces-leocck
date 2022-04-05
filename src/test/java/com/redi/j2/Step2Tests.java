package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Dog;
import com.redi.j2.proxies.Elephant;
import com.redi.j2.proxies.Mammal;
import com.redi.j2.proxies.Platypus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Step2Tests {

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
    void task_2_1_0_shouldCreateTheMammalClass() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // when - we check if it exists

        // then - it should exist
        assertTrue(m.existsClass(), "Mammal class is not defined");
    }

    @Test
    void task_2_1_1_shouldExtendAnimal() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // when - we check if it extends the Animal class

        // then - it should
        assertTrue(m.extendsClass("com.redi.j2.Animal"), "Mammal class must extend from Animal");

        // and - it should be abstract
        assertTrue(m.isAbstract(), "Class Mammal must be abstract");
    }

    @Test
    void task_2_1_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // when - we check if the parameterized constructor exists

        // then - it should exist
        assertTrue(m.hasConstructor(), "Class Mammal must have a default constructor");

        // and - it should have set the blood type to 'WARM'
        assertEquals(BloodType.WARM, m.getBloodType(), "Blood type is not being set to WARM. Please call the constructor from the superclass with the right parameter.");
    }

    @Test
    void task_2_1_3_shouldHaveBreastfeedMethod() {

        // given - the class we want the students to implement
        Mammal m = Fixtures.createMammal();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        m.breastfeed();

        // then - it should print what is expected in the output
        assertEquals("breastfeeding", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_2_0_shouldCreateTheDogClass() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // when - we check if it exists

        // then - it should exist
        assertTrue(d.existsClass(), "Dog class is not defined");
    }

    @Test
    void task_2_2_1_shouldExtendMammal() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // when - we check if it extends the Mammal class

        // then - it should
        assertTrue(d.extendsClass("com.redi.j2.Mammal"), "Dog class must extend from Mammal");
    }

    @Test
    void task_2_2_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // when - we check if the default constructor exists

        // then - it should exist
        assertTrue(d.hasConstructor(), "Class Dog must have a default (no-param) constructor");
    }

    @Test
    void task_2_2_3_shouldOverrideMakeNoiseMethod() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        d.makeNoise();

        // then - it should print what is expected in the output
        assertEquals("woof woof", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_2_4_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Dog d = Fixtures.createDog();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        d.eat();

        // then - it should print what is expected in the output
        assertEquals("This bone is delicious", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_3_0_shouldCreateTheElephantClass() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // when - we check if it exists

        // then - it should exist
        assertTrue(e.existsClass(), "Elephant class is not defined");
    }

    @Test
    void task_2_3_1_shouldExtendMammal() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // when - we check if it extends the Mammal class

        // then - it should
        assertTrue(e.extendsClass("com.redi.j2.Mammal"), "Elephant class must extend from Mammal");
    }

    @Test
    void task_2_3_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // when - we check if the default constructor exists

        // then - it should exist
        assertTrue(e.hasConstructor(), "Class Elephant must have a default (no-param) constructor");
    }

    @Test
    void task_2_3_3_shouldOverrideMakeNoiseMethod() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        e.makeNoise();

        // then - it should print what is expected in the output
        assertEquals("bahruuuuuuhhhhaaaaa", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_3_4_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Elephant e = Fixtures.createElephant();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        e.eat();

        // then - it should print what is expected in the output
        assertEquals("This hay is delicious", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_4_0_shouldCreateThePlatypusClass() {

        // given - the class we want the students to implement
        Platypus p = Fixtures.createPlatypus();

        // when - we check if it exists

        // then - it should exist
        assertTrue(p.existsClass(), "Platypus class is not defined");
    }

    @Test
    void task_2_4_1_shouldExtendMammal() {

        // given - the class we want the students to implement
        Platypus p = Fixtures.createPlatypus();

        // when - we check if it extends the Mammal class

        // then - it should
        assertTrue(p.extendsClass("com.redi.j2.Mammal"), "Platypus class must extend from Mammal");
    }

    @Test
    void task_2_4_2_shouldHaveDefaultConstructor() {

        // given - the class we want the students to implement
        Platypus p = Fixtures.createPlatypus();

        // when - we check if the default constructor exists

        // then - it should exist
        assertTrue(p.hasConstructor(), "Class Platypus must have a default (no-param) constructor");
    }

    @Test
    void task_2_4_3_shouldOverrideMakeNoiseMethod() {

        // given - the class we want the students to implement
        Platypus p = Fixtures.createPlatypus();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        p.makeNoise();

        // then - it should print what is expected in the output
        assertEquals("gyururururururu", out.toString().trim(), "The method should print the correct message");
    }

    @Test
    void task_2_4_4_shouldOverrideEatMethod() {

        // given - the class we want the students to implement
        Platypus p = Fixtures.createPlatypus();

        // and - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we call the method
        p.eat();

        // then - it should print what is expected in the output
        assertEquals("This insect larvae is delicious", out.toString().trim(), "The method should print the correct message");
    }
}
