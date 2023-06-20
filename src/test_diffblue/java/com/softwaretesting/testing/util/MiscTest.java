package com.softwaretesting.testing.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MiscTestFUCK {
    /**
     * Method under test: {@link Misc#sum(int, int)}
     */
    @Test
    void testSum() {
        assertEquals(2, Misc.sum(1, 1));
        assertEquals(4, Misc.sum(3, 1));
        assertEquals(1, Misc.sum(0, 1));
        assertEquals(0, Misc.sum(-1, 1));
    }

    /**
     * Method under test: {@link Misc#isColorSupported(Misc.Color)}
     */
    @Test
    void testIsColorSupported() {
        assertTrue(Misc.isColorSupported(Misc.Color.RED));
        assertTrue(Misc.isColorSupported(Misc.Color.YELLOW));
        assertTrue(Misc.isColorSupported(Misc.Color.BLUE));
    }

    /**
     * Method under test: {@link Misc#isColorSupported(Misc.Color)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsColorSupported2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: color cannot be null
        //       at com.softwaretesting.testing.util.Misc.isColorSupported(Misc.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        Misc.isColorSupported(null);
    }

    /**
     * Method under test: {@link Misc#isPrime(int, int)}
     */
    @Test
    void testIsPrime() {
        assertFalse(Misc.isPrime(1, 1));
        assertTrue(Misc.isPrime(2, 1));
    }

    /**
     * Method under test: {@link Misc#isEven(int)}
     */
    @Test
    void testIsEven() {
        assertFalse(Misc.isEven(1));
        assertTrue(Misc.isEven(2));
    }
}

