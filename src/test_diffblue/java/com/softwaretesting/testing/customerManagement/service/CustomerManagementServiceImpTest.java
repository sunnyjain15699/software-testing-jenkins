package com.softwaretesting.testing.customerManagement.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.softwaretesting.testing.dao.CustomerRepository;
import com.softwaretesting.testing.exception.BadRequestException;
import com.softwaretesting.testing.exception.CustomerNotFoundException;
import com.softwaretesting.testing.model.Customer;
import com.softwaretesting.testing.validator.CustomerValidator;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerManagementServiceImp.class})
@ExtendWith(SpringExtension.class)
class CustomerManagementServiceImpTest {
    @Autowired
    private CustomerManagementServiceImp customerManagementServiceImp;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private CustomerValidator customerValidator;

    /**
     * Method under test: {@link CustomerManagementServiceImp#list()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testList() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Objects.requireNonNull(Objects.java:221)
        //       at java.util.stream.StreamSupport.stream(StreamSupport.java:68)
        //       at com.softwaretesting.testing.customerManagement.service.CustomerManagementServiceImp.list(CustomerManagementServiceImp.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        Iterable<Customer> iterable = mock(Iterable.class);
        when(iterable.spliterator()).thenReturn(null);
        when(customerRepository.findAll()).thenReturn(iterable);
        customerManagementServiceImp.list();
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#list()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testList2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.softwaretesting.testing.exception.CustomerNotFoundException: Msg
        //       at com.softwaretesting.testing.customerManagement.service.CustomerManagementServiceImp.list(CustomerManagementServiceImp.java:30)
        //   See https://diff.blue/R013 to resolve this issue.

        Iterable<Customer> iterable = mock(Iterable.class);
        when(iterable.spliterator()).thenThrow(new CustomerNotFoundException("Msg"));
        when(customerRepository.findAll()).thenReturn(iterable);
        customerManagementServiceImp.list();
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#list()}
     */
    @Test
    void testList3() {
        when(customerRepository.findAll()).thenThrow(new CustomerNotFoundException("Msg"));
        assertThrows(CustomerNotFoundException.class, () -> customerManagementServiceImp.list());
        verify(customerRepository).findAll();
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#findByUserName(String)}
     */
    @Test
    void testFindByUserName() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(customerRepository.findByUserName(Mockito.<String>any())).thenReturn(ofResult);
        doNothing().when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        assertSame(customer, customerManagementServiceImp.findByUserName("janedoe"));
        verify(customerRepository).findByUserName(Mockito.<String>any());
        verify(customerValidator).validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#findByUserName(String)}
     */
    @Test
    void testFindByUserName2() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(customerRepository.findByUserName(Mockito.<String>any())).thenReturn(ofResult);
        doThrow(new CustomerNotFoundException("User-Name")).when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        assertThrows(CustomerNotFoundException.class, () -> customerManagementServiceImp.findByUserName("janedoe"));
        verify(customerRepository).findByUserName(Mockito.<String>any());
        verify(customerValidator).validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#findByUserName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByUserName3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.softwaretesting.testing.customerManagement.service.CustomerManagementServiceImp.findByUserName(CustomerManagementServiceImp.java:41)
        //   See https://diff.blue/R013 to resolve this issue.

        when(customerRepository.findByUserName(Mockito.<String>any())).thenReturn(Optional.empty());
        doNothing().when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        customerManagementServiceImp.findByUserName("janedoe");
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#findById(Long)}
     */
    @Test
    void testFindById() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(customerRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        doNothing().when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        assertSame(customer, customerManagementServiceImp.findById(1L));
        verify(customerRepository).findById(Mockito.<Long>any());
        verify(customerValidator).validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#findById(Long)}
     */
    @Test
    void testFindById2() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(customerRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        doThrow(new CustomerNotFoundException("id")).when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        assertThrows(CustomerNotFoundException.class, () -> customerManagementServiceImp.findById(1L));
        verify(customerRepository).findById(Mockito.<Long>any());
        verify(customerValidator).validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#findById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.softwaretesting.testing.customerManagement.service.CustomerManagementServiceImp.findById(CustomerManagementServiceImp.java:51)
        //   See https://diff.blue/R013 to resolve this issue.

        when(customerRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        doNothing().when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        customerManagementServiceImp.findById(1L);
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#selectCustomerByPhoneNumber(String)}
     */
    @Test
    void testSelectCustomerByPhoneNumber() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(customerRepository.selectCustomerByPhoneNumber(Mockito.<String>any())).thenReturn(ofResult);
        doNothing().when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        assertSame(customer, customerManagementServiceImp.selectCustomerByPhoneNumber("6625550144"));
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
        verify(customerValidator).validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#selectCustomerByPhoneNumber(String)}
     */
    @Test
    void testSelectCustomerByPhoneNumber2() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        Optional<Customer> ofResult = Optional.of(customer);
        when(customerRepository.selectCustomerByPhoneNumber(Mockito.<String>any())).thenReturn(ofResult);
        doThrow(new CustomerNotFoundException("phone number")).when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        assertThrows(CustomerNotFoundException.class,
                () -> customerManagementServiceImp.selectCustomerByPhoneNumber("6625550144"));
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
        verify(customerValidator).validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#selectCustomerByPhoneNumber(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSelectCustomerByPhoneNumber3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.softwaretesting.testing.customerManagement.service.CustomerManagementServiceImp.selectCustomerByPhoneNumber(CustomerManagementServiceImp.java:61)
        //   See https://diff.blue/R013 to resolve this issue.

        when(customerRepository.selectCustomerByPhoneNumber(Mockito.<String>any())).thenReturn(Optional.empty());
        doNothing().when(customerValidator)
                .validate404(Mockito.<Optional<Object>>any(), Mockito.<String>any(), Mockito.<String>any());
        customerManagementServiceImp.selectCustomerByPhoneNumber("6625550144");
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#delete(Long)}
     */
    @Test
    void testDelete() {
        doNothing().when(customerRepository).deleteById(Mockito.<Long>any());
        when(customerRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        customerManagementServiceImp.delete(1L);
        verify(customerRepository).existsById(Mockito.<Long>any());
        verify(customerRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#delete(Long)}
     */
    @Test
    void testDelete2() {
        doThrow(new CustomerNotFoundException("Msg")).when(customerRepository).deleteById(Mockito.<Long>any());
        when(customerRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        assertThrows(CustomerNotFoundException.class, () -> customerManagementServiceImp.delete(1L));
        verify(customerRepository).existsById(Mockito.<Long>any());
        verify(customerRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#delete(Long)}
     */
    @Test
    void testDelete3() {
        doNothing().when(customerRepository).deleteById(Mockito.<Long>any());
        when(customerRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        assertThrows(CustomerNotFoundException.class, () -> customerManagementServiceImp.delete(1L));
        verify(customerRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#addCustomer(Customer)}
     */
    @Test
    void testAddCustomer() {
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
        Optional<Customer> ofResult = Optional.of(customer2);
        when(customerRepository.save(Mockito.<Customer>any())).thenReturn(customer);
        when(customerRepository.selectCustomerByPhoneNumber(Mockito.<String>any())).thenReturn(ofResult);

        Customer customer3 = new Customer();
        customer3.setId(1L);
        customer3.setName("Name");
        customer3.setPhoneNumber("6625550144");
        customer3.setUserName("janedoe");
        assertThrows(BadRequestException.class, () -> customerManagementServiceImp.addCustomer(customer3));
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#addCustomer(Customer)}
     */
    @Test
    void testAddCustomer2() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        when(customerRepository.save(Mockito.<Customer>any())).thenReturn(customer);
        when(customerRepository.selectCustomerByPhoneNumber(Mockito.<String>any())).thenReturn(Optional.empty());

        Customer customer2 = new Customer();
        customer2.setId(1L);
        customer2.setName("Name");
        customer2.setPhoneNumber("6625550144");
        customer2.setUserName("janedoe");
        assertSame(customer, customerManagementServiceImp.addCustomer(customer2));
        verify(customerRepository).save(Mockito.<Customer>any());
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#addCustomer(Customer)}
     */
    @Test
    void testAddCustomer3() {
        when(customerRepository.save(Mockito.<Customer>any())).thenThrow(new BadRequestException("Msg"));
        when(customerRepository.selectCustomerByPhoneNumber(Mockito.<String>any()))
                .thenThrow(new BadRequestException("Msg"));

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        assertThrows(BadRequestException.class, () -> customerManagementServiceImp.addCustomer(customer));
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#saveAll(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveAll() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at java.util.Objects.requireNonNull(Objects.java:221)
        //       at java.util.stream.StreamSupport.stream(StreamSupport.java:68)
        //       at com.softwaretesting.testing.customerManagement.service.CustomerManagementServiceImp.saveAll(CustomerManagementServiceImp.java:92)
        //   See https://diff.blue/R013 to resolve this issue.

        Iterable<Customer> iterable = mock(Iterable.class);
        when(iterable.spliterator()).thenReturn(null);
        when(customerRepository.saveAll(Mockito.<Iterable<Customer>>any())).thenReturn(iterable);
        customerManagementServiceImp.saveAll(new ArrayList<>());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#saveAll(List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveAll2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.softwaretesting.testing.exception.CustomerNotFoundException: Msg
        //       at com.softwaretesting.testing.customerManagement.service.CustomerManagementServiceImp.saveAll(CustomerManagementServiceImp.java:92)
        //   See https://diff.blue/R013 to resolve this issue.

        Iterable<Customer> iterable = mock(Iterable.class);
        when(iterable.spliterator()).thenThrow(new CustomerNotFoundException("Msg"));
        when(customerRepository.saveAll(Mockito.<Iterable<Customer>>any())).thenReturn(iterable);
        customerManagementServiceImp.saveAll(new ArrayList<>());
    }

    /**
     * Method under test: {@link CustomerManagementServiceImp#saveAll(List)}
     */
    @Test
    void testSaveAll3() {
        when(customerRepository.saveAll(Mockito.<Iterable<Customer>>any()))
                .thenThrow(new CustomerNotFoundException("Msg"));
        assertThrows(CustomerNotFoundException.class, () -> customerManagementServiceImp.saveAll(new ArrayList<>()));
        verify(customerRepository).saveAll(Mockito.<Iterable<Customer>>any());
    }
}

