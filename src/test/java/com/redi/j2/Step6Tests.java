package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Viviparous;
import com.redi.j2.utils.ReflectionProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Step6Tests {

    @Test
    void task_6_0_0_shouldDefineInterfaceViviparous() {

        // given - an interface we want the students to implement
        Viviparous v;

        // when - we check if it exists
        v = Fixtures.createViviparous();

        // then - it should exist
        assertTrue(v.existsClass(), "Viviparous interface is not defined");

        // and - it should be an interface
        assertTrue(v.isInterface(), "Viviparous must be an interface");
    }

    @Test
    void task_6_1_1_shouldDefineMethodGetMaxBabies() {

        // given - the Viviparous interface
        Viviparous s = Fixtures.createViviparous();

        // when - we check if it has the 'getMaxBabies' method definition

        // then - it should exist
        assertTrue(s.hasMethod("getMaxBabies"), "Method 'getMaxBabies' is not defined or does not have zero parameters");

        // and - it should be abstract
        assertTrue(s.isMethodAbstract("getMaxBabies"), "Method 'getMaxBabies' must be abstract");

        // and - it should have the correct return type
        assertTrue(s.isMethodReturnType(int.class, "getMaxBabies"), "Method 'getMaxBabies' should return int");

        // and - it should have public access
        assertTrue(s.isMethodPublic("getMaxBabies"), "Method 'getMaxBabies' should be public");
    }

    @Test
    void task_6_1_2_shouldDefineMethodGiveBirth() {

        // given - the Viviparous interface
        Viviparous s = Fixtures.createViviparous();

        // when - we check if it has the 'giveBirth' method definition

        // then - it should exist
        assertTrue(s.hasMethod("giveBirth"), "Method 'giveBirth' is not defined or does not have zero parameters");

        // and - it should be abstract
        assertTrue(s.isMethodAbstract("giveBirth"), "Method 'giveBirth' must be abstract");

        // and - it should have the correct return type
        assertTrue(s.isMethodReturnType(int.class, "giveBirth"), "Method 'giveBirth' should return int");

        // and - it should have public access
        assertTrue(s.isMethodPublic("giveBirth"), "Method 'giveBirth' should be public");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllViviparous")
    void task_6_2_A_shouldImplementInterfaceViviparous(String className, ReflectionProxy viviparous, int maxBabies) {

        // given - an animal we expect is Viviparous

        // when - we check if it implements the 'Viviparous' interface
        Viviparous v = Fixtures.createViviparous();

        // then - it should
        assertTrue(viviparous.implementsInterface(v.getTargetClass()), className + " should implement the Viviparous interface");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllViviparous")
    void task_6_2_B_shouldImplementMethodGetMaxBabies(String className, ReflectionProxy viviparous, int maxBabies) {

        // given - an animal we expect is Viviparous

        // when - we call the method
        Integer max = viviparous.invokeMethod("getMaxBabies", new Class[]{});

        // then - it should return what is defined in the exercise
        assertEquals(maxBabies, max, className + " must return the correct number from getMaxBabies");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllViviparous")
    void task_6_2_C_shouldImplementMethodGiveBirth(String className, ReflectionProxy viviparous, int maxBabies) {

        // given - an animal we expect is Viviparous

        // and - the result of running the method for the first time
        Integer firstBirthResult = viviparous.invokeMethod("giveBirth", new Class[]{});

        // and - a control flag to check if the result was ever different from the first time
        boolean changedAtLeastOnce = false;

        // when - we give birth a couple of times
        for (int i = 0; i < 100; i++) {
            Integer newBabies = viviparous.invokeMethod("giveBirth", new Class[]{});

            // then - the method must exist
            assertNotNull(newBabies, "Number of children is not correct when maxBabies is "+maxBabies);

            // and - the number of children needs to be at least one
            assertTrue(newBabies > 0, "Number of children less than one ("+newBabies+") for a "+className+" (maxBabies is "+maxBabies+")");

            // and - the number of children cannot exceed maxBabies
            assertTrue(newBabies <= maxBabies, "Number of children too big ("+newBabies+") for a "+className+" (maxBabies is "+maxBabies+")");

            if (!firstBirthResult.equals(newBabies)) {
                changedAtLeastOnce = true;
                break;
            }
        }

        // and - the result must have changed at least once
        assertTrue(changedAtLeastOnce, "The method 'giveBirth' always returns the same number: "+firstBirthResult);
    }

    static Stream<Arguments> getAllViviparous() {
        return Stream.of(
                Arguments.of("Dog", Fixtures.createDog(), 24),
                Arguments.of("Elephant", Fixtures.createElephant(), 2),
                Arguments.of("BullShark", Fixtures.createBullShark(), 13)
        );
    }
}