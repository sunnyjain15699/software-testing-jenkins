package com.softwaretesting.testing.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

@ContextConfiguration(classes = {CustomerValidator.class})
@ExtendWith(SpringExtension.class)
class CustomerValidatorTest {
    @Autowired
    private CustomerValidator customerValidator;

    /**
     * Method under test: {@link CustomerValidator#validate404(Optional, String, String)}
     */
    @Test
    void testValidate404() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        customerValidator.validate404(Optional.of("42"), "Label", "42");
    }

    /**
     * Method under test: {@link CustomerValidator#validate404(Optional, String, String)}
     */
    @Test
    void testValidate4042() {
        assertThrows(ResponseStatusException.class, () -> customerValidator.validate404(Optional.empty(), "Label", "42"));
    }
}

