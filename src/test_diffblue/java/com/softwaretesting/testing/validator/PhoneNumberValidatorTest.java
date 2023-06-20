package com.softwaretesting.testing.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PhoneNumberValidator.class})
@ExtendWith(SpringExtension.class)
class PhoneNumberValidatorTest {
    @Autowired
    private PhoneNumberValidator phoneNumberValidator;

    /**
     * Method under test: {@link PhoneNumberValidator#validate(String)}
     */
    @Test
    void testValidate() {
        assertFalse(phoneNumberValidator.validate("foo"));
        assertFalse(phoneNumberValidator.validate("foofoo"));
        assertTrue(phoneNumberValidator.validate("+49foo"));
    }
}

