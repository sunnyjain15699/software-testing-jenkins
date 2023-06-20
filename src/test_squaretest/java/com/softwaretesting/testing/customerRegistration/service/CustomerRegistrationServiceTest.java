package com.softwaretesting.testing.customerRegistration.service;

import com.softwaretesting.testing.dao.CustomerRepository;
import com.softwaretesting.testing.exception.BadRequestException;
import com.softwaretesting.testing.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CustomerRegistrationServiceTest {

    @Mock
    private CustomerRepository mockCustomerRepository;

    private CustomerRegistrationService customerRegistrationServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        customerRegistrationServiceUnderTest = new CustomerRegistrationService(mockCustomerRepository);
    }

    @Disabled("wrongly generated exception class")
    @Test
    void testRegisterNewCustomer_ThrowsBadRequestException() {
        // Setup
        final Customer customer = new Customer(0L, "userName", "name", "phoneNumber");

        // Configure CustomerRepository.selectCustomerByPhoneNumber(...).
        final Optional<Customer> customer1 = Optional.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.selectCustomerByPhoneNumber("phoneNumber")).thenReturn(customer1);

        // Run the test
        assertThatThrownBy(() -> customerRegistrationServiceUnderTest.registerNewCustomer(customer))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void testRegisterNewCustomer_CustomerRepositorySelectCustomerByPhoneNumberReturnsAbsent() {
        // Setup
        final Customer customer = new Customer(0L, "userName", "name", "phoneNumber");
        final Customer expectedResult = new Customer(0L, "userName", "name", "phoneNumber");
        when(mockCustomerRepository.selectCustomerByPhoneNumber("phoneNumber")).thenReturn(Optional.empty());

        // Configure CustomerRepository.save(...).
        final Customer customer1 = new Customer(0L, "userName", "name", "phoneNumber");
        when(mockCustomerRepository.save(new Customer(0L, "userName", "name", "phoneNumber"))).thenReturn(customer1);

        // Run the test
        final Customer result = customerRegistrationServiceUnderTest.registerNewCustomer(customer);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
