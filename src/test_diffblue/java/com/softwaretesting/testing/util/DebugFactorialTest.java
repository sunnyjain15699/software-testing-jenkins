package com.softwaretesting.testing.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DebugFactorialTest {
    /**
     * Method under test: {@link DebugFactorial#factorial(int)}
     */
    @Test
    void testFactorial() {
        assertEquals(1, DebugFactorial.factorial(1));
        assertEquals(2, DebugFactorial.factorial(2));
    }
}

