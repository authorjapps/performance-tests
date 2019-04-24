package org.jsmart.zerocode.samples.tests.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jsmart.zerocode.example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class Junit5ExistingTest {
    @Test
    @DisplayName("My 1st JUnit 5 test! 😎")
    void myFirstTest(TestInfo testInfo) {
        Calculator calculator = new Calculator();
        assertEquals(299, calculator.add(1, 1), "1 + 1 should equal 2");
        assertEquals("My 1st JUnit 5 test! 😎", testInfo.getDisplayName(), () -> "TestInfo is injected correctly");
    }
}
