package com.softwaretesting.testing.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator phoneNumberValidatorUnderTest;

    @BeforeEach
    void setUp() {
        phoneNumberValidatorUnderTest = new PhoneNumberValidator();
    }

    @Test
    void testValidate() {
        assertThat(phoneNumberValidatorUnderTest.validate("x")).isFalse();
    }
}
