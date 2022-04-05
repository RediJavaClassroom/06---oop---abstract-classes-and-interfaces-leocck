package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Fish;
import com.redi.j2.proxies.Swimmer;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Step5Tests {

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
    void task_5_0_0_shouldDefineInterfaceSwimmer() {

        // given - an interface we want the students to implement
        Swimmer s;

        // when - we check if it exists
        s = Fixtures.createSwimmer();

        // then - it should exist
        assertTrue(s.existsClass(), "Swimmer interface is not defined");

        // and - it should be an interface
        assertTrue(s.isInterface(), "Swimmer must be an interface");
    }

    @Test
    void task_5_1_1_shouldDefineMethodSwim() {

        // given - the Swimmer interface
        Swimmer s = Fixtures.createSwimmer();

        // when - we check if it has the 'draw' method definition

        // then - it should exist
        assertTrue(s.hasMethod("swim"), "Method 'swim' is not defined or does not have zero parameters");

        // and - it should be abstract
        assertTrue(s.isMethodAbstract("swim"), "Method 'swim' must be abstract");

        // and - it should have the correct return type
        assertTrue(s.isMethodReturnType(void.class, "swim"), "Method 'swim' should return void");

        // and - it should have public access
        assertTrue(s.isMethodPublic("swim"), "Method 'swim' should be public");
    }

    @Test
    void task_5_2_0_shouldImplementSwimmer() {

        // given - a Fish
        Fish f = Fixtures.createFish();

        // when - we check if it implements the 'Swimmer' interface
        Swimmer s = Fixtures.createSwimmer();

        // then - it should
        assertTrue(f.implementsInterface(s.getTargetClass()), "Fish should implement the Swimmer interface");
    }

    @Test
    void task_5_2_1_shouldNotImplementMethodSwim() {

        // given - a Fish
        Fish f = Fixtures.createFish();

        // when - we check if it has the 'swim' method

        // then - it should NOT exist
        assertFalse(f.hasMethod("swim"), "Method 'swim' should not be implement by Fish, but rather in the concrete classes");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllFish")
    void task_5_3_0_shouldDefineMethodSwimInConcreteClasses(String className, ReflectionProxy fish) {

        // given - a concrete implementation of Fish class

        // when - we check if it has the 'swim' method

        // then - it should exist
        assertTrue(fish.hasMethod("swim"), "Method 'swim' should be implemented by the "+fish.getClass().getSimpleName()+" class");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllFish")
    void task_5_3_1_shouldImplementMethodSwimInConcreteClasses(String className, ReflectionProxy fish) {

        // given - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we execute the 'swim' method
        fish.invokeMethod("swim", new Class[]{});

        // then - it should print something in the output
        assertNotNull(out.toString(), "");
        assertNotEquals("", out.toString().trim(), "The "+fish.getClass().getSimpleName()+" class should print something in the 'swim' method");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getSwimmerMammals")
    void task_5_4_0_shouldImplementSwimmerInSomeMammals(String className, ReflectionProxy mammal) {

        // given - the output stream
        ByteArrayOutputStream out = setUpStream();

        // when - we check if it implements the 'Swimmer' interface
        Swimmer s = Fixtures.createSwimmer();

        // then - it should
        assertTrue(mammal.implementsInterface(s.getTargetClass()), "Fish should implement the Swimmer interface");

        // and - it should implement the method correctly
        mammal.invokeMethod("swim", new Class[]{});
        assertNotNull(out.toString(), "");
        assertNotEquals("", out.toString().trim(), "The "+className+" class should print something in the 'swim' method");
    }

    static Stream<Arguments> getAllFish() {
        return Stream.of(
                Arguments.of("Salmon", Fixtures.createSalmon()),
                Arguments.of("CatShark", Fixtures.createCatShark()),
                Arguments.of("BullShark", Fixtures.createBullShark())
        );
    }

    static Stream<Arguments> getSwimmerMammals() {
        return Stream.of(
                Arguments.of("Dog", Fixtures.createDog()),
                Arguments.of("Platypus", Fixtures.createPlatypus())
        );
    }
}
