package com.softwaretesting.testing.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#Customer()}
     *   <li>{@link Customer#setId(Long)}
     *   <li>{@link Customer#setName(String)}
     *   <li>{@link Customer#setPhoneNumber(String)}
     *   <li>{@link Customer#setUserName(String)}
     *   <li>{@link Customer#toString()}
     *   <li>{@link Customer#getId()}
     *   <li>{@link Customer#getName()}
     *   <li>{@link Customer#getPhoneNumber()}
     *   <li>{@link Customer#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        actualCustomer.setId(1L);
        actualCustomer.setName("Name");
        actualCustomer.setPhoneNumber("6625550144");
        actualCustomer.setUserName("janedoe");
        String actualToStringResult = actualCustomer.toString();
        assertEquals(1L, actualCustomer.getId().longValue());
        assertEquals("Name", actualCustomer.getName());
        assertEquals("6625550144", actualCustomer.getPhoneNumber());
        assertEquals("janedoe", actualCustomer.getUserName());
        assertEquals("Customer{id=1, userName='janedoe', name='Name', phoneNumber='6625550144'}", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#Customer(Long, String, String, String)}
     *   <li>{@link Customer#setId(Long)}
     *   <li>{@link Customer#setName(String)}
     *   <li>{@link Customer#setPhoneNumber(String)}
     *   <li>{@link Customer#setUserName(String)}
     *   <li>{@link Customer#toString()}
     *   <li>{@link Customer#getId()}
     *   <li>{@link Customer#getName()}
     *   <li>{@link Customer#getPhoneNumber()}
     *   <li>{@link Customer#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Customer actualCustomer = new Customer(1L, "janedoe", "Name", "6625550144");
        actualCustomer.setId(1L);
        actualCustomer.setName("Name");
        actualCustomer.setPhoneNumber("6625550144");
        actualCustomer.setUserName("janedoe");
        String actualToStringResult = actualCustomer.toString();
        assertEquals(1L, actualCustomer.getId().longValue());
        assertEquals("Name", actualCustomer.getName());
        assertEquals("6625550144", actualCustomer.getPhoneNumber());
        assertEquals("janedoe", actualCustomer.getUserName());
        assertEquals("Customer{id=1, userName='janedoe', name='Name', phoneNumber='6625550144'}", actualToStringResult);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.softwaretesting.testing.model.Customer.equals(Customer.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        Customer customer = new Customer();
        customer.setId(null);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertThrows(NullPointerException.class, () -> customer.equals(customer2));
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals8() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.softwaretesting.testing.model.Customer.equals(Customer.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName(null);
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertThrows(NullPointerException.class, () -> customer.equals(customer2));
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals10() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.softwaretesting.testing.model.Customer.equals(Customer.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber(null);
        customer.setUserName("janedoe");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertThrows(NullPointerException.class, () -> customer.equals(customer2));
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals12() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.softwaretesting.testing.model.Customer.equals(Customer.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName(null);

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertThrows(NullPointerException.class, () -> customer.equals(customer2));
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        assertNotEquals(customer, null);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals2() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        assertNotEquals(customer, "Different type to Customer");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#equals(Object)}
     *   <li>{@link Customer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        assertEquals(customer, customer);
        int expectedHashCodeResult = customer.hashCode();
        assertEquals(expectedHashCodeResult, customer.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#equals(Object)}
     *   <li>{@link Customer#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertEquals(customer, customer2);
        int expectedHashCodeResult = customer.hashCode();
        assertEquals(expectedHashCodeResult, customer2.hashCode());
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals5() {
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertNotEquals(customer, customer2);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals7() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("janedoe");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertNotEquals(customer, customer2);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals9() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("8605550118");
        customer.setUserName("janedoe");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertNotEquals(customer, customer2);
    }

    /**
     * Method under test: {@link Customer#equals(Object)}
     */
    @Test
    void testEquals11() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("Name");

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertNotEquals(customer, customer2);
    }
}

