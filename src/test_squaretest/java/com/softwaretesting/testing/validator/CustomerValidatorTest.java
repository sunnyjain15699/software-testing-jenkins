package com.softwaretesting.testing.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class CustomerValidatorTest {

    private CustomerValidator customerValidatorUnderTest;

    @BeforeEach
    void setUp() {
        customerValidatorUnderTest = new CustomerValidator();
    }

    @Test
    void testValidate404() {
        // Setup
        // Run the test
        customerValidatorUnderTest.validate404(Optional.of("value"), "label", "value");

        // Verify the results
    }
}
