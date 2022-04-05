package com.redi.j2;

import com.redi.j2.fixtures.Fixtures;
import com.redi.j2.proxies.Oviparous;
import com.redi.j2.utils.ReflectionProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Step7Tests {

    @Test
    void task_7_0_0_shouldDefineInterfaceOviparous() {

        // given - an interface we want the students to implement
        Oviparous v;

        // when - we check if it exists
        v = Fixtures.createOviparous();

        // then - it should exist
        assertTrue(v.existsClass(), "Oviparous interface is not defined");

        // and - it should be an interface
        assertTrue(v.isInterface(), "Oviparous must be an interface");
    }

    @Test
    void task_7_1_1_shouldDefineMethodGetMaxEggs() {

        // given - the Oviparous interface
        Oviparous s = Fixtures.createOviparous();

        // when - we check if it has the 'getMaxEggs' method definition

        // then - it should exist
        assertTrue(s.hasMethod("getMaxEggs"), "Method 'getMaxEggs' is not defined or does not have zero parameters");

        // and - it should be abstract
        assertTrue(s.isMethodAbstract("getMaxEggs"), "Method 'getMaxEggs' must be abstract");

        // and - it should have the correct return type
        assertTrue(s.isMethodReturnType(int.class, "getMaxEggs"), "Method 'getMaxEggs' should return int");

        // and - it should have public access
        assertTrue(s.isMethodPublic("getMaxEggs"), "Method 'getMaxEggs' should be public");
    }

    @Test
    void task_7_1_2_shouldDefineMethodLayEggs() {

        // given - the Oviparous interface
        Oviparous s = Fixtures.createOviparous();

        // when - we check if it has the 'layEggs' method definition

        // then - it should exist
        assertTrue(s.hasMethod("layEggs"), "Method 'layEggs' is not defined or does not have zero parameters");

        // and - it should be abstract
        assertTrue(s.isMethodAbstract("layEggs"), "Method 'layEggs' must be abstract");

        // and - it should have the correct return type
        assertTrue(s.isMethodReturnType(int.class, "layEggs"), "Method 'layEggs' should return int");

        // and - it should have public access
        assertTrue(s.isMethodPublic("layEggs"), "Method 'layEggs' should be public");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllOviparous")
    void task_7_2_A_shouldImplementInterfaceOviparous(String className, ReflectionProxy oviparous, Integer maxEggsFirstTime, Integer maxEggsAfterFirstTime) {

        // given - an animal we expect is Oviparous

        // when - we check if it implements the 'Oviparous' interface
        Oviparous v = Fixtures.createOviparous();

        // then - it should
        assertTrue(oviparous.implementsInterface(v.getTargetClass()), className + " should implement the Oviparous interface");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllOviparous")
    void task_7_2_B_shouldImplementMethodGetMaxEggs(String className, ReflectionProxy oviparous, Integer maxEggsFirstTime, Integer maxEggsAfterFirstTime) {

        // given - an animal we expect is Oviparous

        // when - we call the method
        Integer max = oviparous.invokeMethod("getMaxEggs", new Class[]{});

        // then - it should return what is defined in the exercise for the first time laying eggs
        assertEquals(maxEggsFirstTime, max, className + " must return the correct number from getMaxEggs");

        // and - it should return what is defined in the exercise after have laid eggs for the first time
        oviparous.invokeMethod("layEggs", new Class[]{});
        max = oviparous.invokeMethod("getMaxEggs", new Class[]{});
        assertEquals(maxEggsAfterFirstTime, max, className + " must return the correct number from getMaxEggs after the first time");
    }

    @ParameterizedTest(name="{0} class")
    @MethodSource("getAllOviparous")
    void task_7_2_C_shouldImplementMethodLayEggs(String className, ReflectionProxy oviparous, Integer maxEggsFirstTime, Integer maxEggsAfterFirstTime) {

        // given - an animal we expect is Oviparous

        // and - the result of running the method for the first time
        Integer firstBirthResult = oviparous.invokeMethod("layEggs", new Class[]{});

        // and - the number of eggs cannot exceed maxEggs
        assertNotNull(firstBirthResult, "Error in the layEggs method");
        assertTrue(firstBirthResult <= maxEggsFirstTime, "Number of eggs too big ("+firstBirthResult+") for a "+className+" (maxEggs is "+maxEggsFirstTime+") after the first time");

        // and - a control flag to check if the result was ever different from the first time
        boolean changedAtLeastOnce = false;

        // when - we give birth a couple of times
        for (int i = 0; i < 100; i++) {
            Integer newEggs = oviparous.invokeMethod("layEggs", new Class[]{});

            // and - the method must exist
            assertNotNull(newEggs, "Number of eggs is not correct when maxEggs is "+maxEggsFirstTime);

            // and - the number of eggs needs to be at least one
            if (maxEggsAfterFirstTime > 0)
                assertTrue(newEggs > 0, "Number of eggs less than one ("+newEggs+") for a "+className+" (maxEggs is "+maxEggsAfterFirstTime+")");

            // and - the number of eggs cannot exceed maxEggs
            assertTrue(newEggs <= maxEggsAfterFirstTime, "Number of eggs too big ("+newEggs+") for a "+className+" (maxEggs is "+maxEggsAfterFirstTime+") after the first time");

            if (!firstBirthResult.equals(newEggs)) {
                changedAtLeastOnce = true;
                break;
            }
        }

        // and - the result must have changed at least once
        assertTrue(changedAtLeastOnce, "The method 'layEggs' always returns the same number: "+firstBirthResult);
    }

    static Stream<Arguments> getAllOviparous() {
        return Stream.of(
                Arguments.of("Salmon", Fixtures.createSalmon(), 2800, 0),
                Arguments.of("CatShark", Fixtures.createCatShark(), 20, 20),
                Arguments.of("Platypus", Fixtures.createPlatypus(), 2, 2)
        );
    }
}