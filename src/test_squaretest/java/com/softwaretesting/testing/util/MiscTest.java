package com.softwaretesting.testing.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class MiscTest {

    @Test
    void testSum() {
        assertThat(Misc.sum(0, 0)).isEqualTo(0);
    }

    @Test
    void testDivide() {
        assertThat(Misc.divide(4, 2)).isEqualTo(2, within(0.0001));
    }

    @Test
    void testIsColorSupported() {
        assertThat(Misc.isColorSupported(Misc.Color.RED)).isTrue();
    }

    @Test
    void testCalculateFactorial() {
        assertThat(Misc.calculateFactorial(5)).isEqualTo(120);
    }

    @Test
    void testIsPrime() {
        assertThat(Misc.isPrime(9, 2)).isFalse();
    }

    @Test
    void testIsEven() {
        assertThat(Misc.isEven(3)).isFalse();
    }
}
