package com.softwaretesting.testing.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DebugFactorialTest {

    @Test
    void testFactorial() {
        assertThat(DebugFactorial.factorial(5)).isEqualTo(120);
    }

    @Test
    void testMain() {
        // Setup
        // Run the test
        DebugFactorial.main(new String[]{"args"});

        // Verify the results
    }
}
