package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Mammal;
import com.redi.j2.proxies.Walker;
import com.redi.j2.utils.ReflectionProxy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Step4Tests {

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
    void task_4_0_0_shouldDefineInterfaceWalker() {

        // given - an interface we want the students to implement
        Walker w;

        // when - we check if it exists
        w = Fixtures.createWalker();

        // then - it should exist
        assertTrue(w.existsClass(), "Walker interface is not defined");

        // and - it should be an interface
        assertTrue(w.isInterface(), "Walker must be an interface");
    }

    @Test
    void task_4_1_1_shouldDefineMethodWalk() {

        // given - the Walker interface
        Walker w = Fixtures.createWalker();

        // when - we check if it has the 'draw' method definition

        // then - it should exist
        assertTrue(w.hasMethod("walk"), "Method 'walk' is not defined or does not have zero parameters");

        // and - it should be abstract
        assertTrue(w.isMethodAbstract("walk"), "Method 'walk' must be abstract");

        // and - it should have the correct return type
        assertTrue(w.isMethodReturnType(void.class, "walk"), "Method 'walk' should return void");

        // and - it should have public access
        assertTrue(w.isMethodPublic("walk"), "Method 'walk' should be public");
    }

    @Test
    void task_4_2_0_shouldImplementWalker() {

        // given - a Mammal
        Mammal m = Fixtures.createMammal();

        // when - we check if it implements the 'Walker' interface
        Walker w = Fixtures.createWalker();

        // then - it should
        assertTrue(m.implementsInterface(w.getTargetClass()), "Mammal should implement the Walker interface");
    }

    @Test
    void task_4_2_1_shouldNotImplementMethodWalk() {

        // given - a Mammal
        Mammal m = Fixtures.createMammal();

        // when - we check if it has the 'walk' method

        // then - it should NOT exist
        assertFalse(m.hasMethod("walk"), "Method 'walk' should not be implement by Mammal, but rather in the concrete classes");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllMammals")
    void task_4_3_0_shouldDefineMethodWalkInConcreteClasses(String className, ReflectionProxy mammal) {

        // given - a concrete implementation of Mammal class

        // when - we check if it has the 'walk' method

        // then - it should exist
        assertTrue(mammal.hasMethod("walk"), "Method 'walk' should be implemented by the "+mammal.getClass().getSimpleName()+" class");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllMammals")
    void task_4_3_1_shouldImplementMethodWalkInConcreteClasses(String className, ReflectionProxy mammal) {

        // given - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we execute the 'walk' method
        mammal.invokeMethod("walk", new Class[]{});

        // then - it should print something in the output
        assertNotNull(out.toString(), "");
        assertNotEquals("", out.toString().trim(), "The "+mammal.getClass().getSimpleName()+" class should print something in the 'walk' method");
    }

    static Stream<Arguments> getAllMammals() {
        return Stream.of(
                Arguments.of("Dog", Fixtures.createDog()),
                Arguments.of("Elephant", Fixtures.createElephant()),
                Arguments.of("Platypus", Fixtures.createPlatypus())
        );
    }
}
