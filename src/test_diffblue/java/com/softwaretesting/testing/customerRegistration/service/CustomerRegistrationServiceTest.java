package com.softwaretesting.testing.customerRegistration.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.softwaretesting.testing.dao.CustomerRepository;
import com.softwaretesting.testing.exception.BadRequestException;
import com.softwaretesting.testing.model.Customer;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerRegistrationService.class})
@ExtendWith(SpringExtension.class)
class CustomerRegistrationServiceTest {
    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @MockBean
    private CustomerRepository customerRepository;

    /**
     * Method under test: {@link CustomerRegistrationService#registerNewCustomer(Customer)}
     */
    @Test
    void testRegisterNewCustomer() {
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
        assertThrows(IllegalStateException.class, () -> customerRegistrationService.registerNewCustomer(customer3));
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerRegistrationService#registerNewCustomer(Customer)}
     */
    @Test
    void testRegisterNewCustomer2() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setPhoneNumber("6625550144");
        customer.setUserName("janedoe");
        Customer customer2 = mock(Customer.class);
        when(customer2.getName()).thenReturn("foo");
        doNothing().when(customer2).setId(Mockito.<Long>any());
        doNothing().when(customer2).setName(Mockito.<String>any());
        doNothing().when(customer2).setPhoneNumber(Mockito.<String>any());
        doNothing().when(customer2).setUserName(Mockito.<String>any());
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
        assertThrows(BadRequestException.class, () -> customerRegistrationService.registerNewCustomer(customer3));
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
        verify(customer2).getName();
        verify(customer2).setId(Mockito.<Long>any());
        verify(customer2).setName(Mockito.<String>any());
        verify(customer2).setPhoneNumber(Mockito.<String>any());
        verify(customer2).setUserName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerRegistrationService#registerNewCustomer(Customer)}
     */
    @Test
    void testRegisterNewCustomer3() {
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
        assertSame(customer, customerRegistrationService.registerNewCustomer(customer2));
        verify(customerRepository).save(Mockito.<Customer>any());
        verify(customerRepository).selectCustomerByPhoneNumber(Mockito.<String>any());
    }
}

