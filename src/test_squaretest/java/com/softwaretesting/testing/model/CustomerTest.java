package com.softwaretesting.testing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    private Customer customerUnderTest;

    @BeforeEach
    void setUp() {
        customerUnderTest = new Customer(0L, "userName", "name", "phoneNumber");
    }

    @Test
    void testEquals() {
        // Setup
        // Run the test
        final boolean result = customerUnderTest.equals("o");

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(customerUnderTest.hashCode()).isEqualTo(Objects.hash(customerUnderTest.getId(),customerUnderTest.getUserName(),customerUnderTest.getName(),customerUnderTest.getPhoneNumber()));
    }

    @Test
    void testToString() {
        assertThat(customerUnderTest.toString()).isEqualTo( "Customer{" + "id=" + customerUnderTest.getId() + ", userName='" + customerUnderTest.getUserName() + '\'' + ", name='" + customerUnderTest.getName()+ '\'' +", phoneNumber='" + customerUnderTest.getPhoneNumber() + '\'' + '}');
    }
}
