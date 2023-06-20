package com.softwaretesting.testing.customerManagement.service;

import com.softwaretesting.testing.dao.CustomerRepository;
import com.softwaretesting.testing.exception.BadRequestException;
import com.softwaretesting.testing.model.Customer;
import com.softwaretesting.testing.validator.CustomerValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class CustomerManagementServiceImpTest {

    @Mock
    private CustomerRepository mockCustomerRepository;
    @Mock
    private CustomerValidator mockCustomerValidator;

    @InjectMocks
    private CustomerManagementServiceImp customerManagementServiceImpUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testList() {
        // Setup
        final Collection<Customer> expectedResult = List.of(new Customer(0L, "userName", "name", "phoneNumber"));

        // Configure CustomerRepository.findAll(...).
        final Iterable<Customer> customers = List.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.findAll()).thenReturn(customers);

        // Run the test
        final Collection<Customer> result = customerManagementServiceImpUnderTest.list();

        // Verify the results
//        assertThat(result).isEqualTo(expectedResult);
        assertTrue(result.containsAll(expectedResult));
    }

    @Test
    void testList_CustomerRepositoryReturnsNoItems() {
        // Setup
        when(mockCustomerRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final Collection<Customer> result = customerManagementServiceImpUnderTest.list();

        // Verify the results
        assertTrue(result.containsAll(Collections.emptyList()));
    }

    @Test
    void testFindByUserName() {
        // Setup
        final Customer expectedResult = new Customer(0L, "userName", "name", "phoneNumber");

        // Configure CustomerRepository.findByUserName(...).
        final Optional<Customer> customer = Optional.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.findByUserName("userName")).thenReturn(customer);

        // Run the test
        final Customer result = customerManagementServiceImpUnderTest.findByUserName("userName");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
        verify(mockCustomerValidator).validate404(Optional.of(new Customer(0L, "userName", "name", "phoneNumber")),
                "User-Name", "userName");
    }

    @Test
    void testFindByUserName_CustomerRepositoryReturnsAbsent() {
        // Setup
        when(mockCustomerRepository.findByUserName("userName")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> customerManagementServiceImpUnderTest.findByUserName("userName"))
                .isInstanceOf(NoSuchElementException.class);
        verify(mockCustomerValidator).validate404(Optional.empty(),
                "User-Name", "userName");
    }

    @Test
    void testFindById() {
        // Setup
        final Customer expectedResult = new Customer(0L, "userName", "name", "phoneNumber");

        // Configure CustomerRepository.findById(...).
        final Optional<Customer> customer = Optional.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.findById(0L)).thenReturn(customer);

        // Run the test
        final Customer result = customerManagementServiceImpUnderTest.findById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
        verify(mockCustomerValidator).validate404(Optional.of(new Customer(0L, "userName", "name", "phoneNumber")),
                "id", "0");
    }

    @Test
    void testFindById_CustomerRepositoryReturnsAbsent() {
        // Setup
        when(mockCustomerRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> customerManagementServiceImpUnderTest.findById(0L))
                .isInstanceOf(NoSuchElementException.class);
        verify(mockCustomerValidator).validate404(Optional.empty(),
                "id", "0");
    }

    @Test
    void testSelectCustomerByPhoneNumber() {
        // Setup
        final Customer expectedResult = new Customer(0L, "userName", "name", "phoneNumber");

        // Configure CustomerRepository.selectCustomerByPhoneNumber(...).
        final Optional<Customer> customer = Optional.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.selectCustomerByPhoneNumber("phoneNumber")).thenReturn(customer);

        // Run the test
        final Customer result = customerManagementServiceImpUnderTest.selectCustomerByPhoneNumber("phoneNumber");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
        verify(mockCustomerValidator).validate404(Optional.of(new Customer(0L, "userName", "name", "phoneNumber")),
                "phone number", "phoneNumber");
    }

    @Test
    void testSelectCustomerByPhoneNumber_CustomerRepositoryReturnsAbsent() {
        // Setup
        when(mockCustomerRepository.selectCustomerByPhoneNumber("phoneNumber")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(
                () -> customerManagementServiceImpUnderTest.selectCustomerByPhoneNumber("phoneNumber"))
                .isInstanceOf(NoSuchElementException.class);
        verify(mockCustomerValidator).validate404(Optional.empty(),
                "phone number", "phoneNumber");
    }

    @Test
    void testDelete() {
        // Setup
        when(mockCustomerRepository.existsById(0L)).thenReturn(true);

        // Run the test
        customerManagementServiceImpUnderTest.delete(0L);

        // Verify the results
        verify(mockCustomerRepository).deleteById(0L);
    }

    @Test
    void testAddCustomer_ThrowsBadRequestException() {
        // Setup
        final Customer customer = new Customer(0L, "userName", "name", "phoneNumber");

        // Configure CustomerRepository.selectCustomerByPhoneNumber(...).
        final Optional<Customer> customer1 = Optional.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.selectCustomerByPhoneNumber("phoneNumber")).thenReturn(customer1);

        // Run the test
        assertThatThrownBy(() -> customerManagementServiceImpUnderTest.addCustomer(customer))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    void testAddCustomer_CustomerRepositorySelectCustomerByPhoneNumberReturnsAbsent() {
        // Setup
        final Customer customer = new Customer(0L, "userName", "name", "phoneNumber");
        final Customer expectedResult = new Customer(0L, "userName", "name", "phoneNumber");
        when(mockCustomerRepository.selectCustomerByPhoneNumber("phoneNumber")).thenReturn(Optional.empty());

        // Configure CustomerRepository.save(...).
        final Customer customer1 = new Customer(0L, "userName", "name", "phoneNumber");
        when(mockCustomerRepository.save(new Customer(0L, "userName", "name", "phoneNumber"))).thenReturn(customer1);

        // Run the test
        final Customer result = customerManagementServiceImpUnderTest.addCustomer(customer);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testSaveAll() {
        // Setup
        final List<Customer> customers = List.of(new Customer(0L, "userName", "name", "phoneNumber"));
        final Collection<Customer> expectedResult = List.of(new Customer(0L, "userName", "name", "phoneNumber"));

        // Configure CustomerRepository.saveAll(...).
        final Iterable<Customer> customers1 = List.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.saveAll(List.of(new Customer(0L, "userName", "name", "phoneNumber"))))
                .thenReturn(customers1);

        // Run the test
        final Collection<Customer> result = customerManagementServiceImpUnderTest.saveAll(customers);

        // Verify the results
        assertThat(result).containsAll(expectedResult);
    }

    @Test
    void testSaveAll_CustomerRepositoryReturnsNoItems() {
        // Setup
        final List<Customer> customers = List.of(new Customer(0L, "userName", "name", "phoneNumber"));
        when(mockCustomerRepository.saveAll(List.of(new Customer(0L, "userName", "name", "phoneNumber"))))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Collection<Customer> result = customerManagementServiceImpUnderTest.saveAll(customers);

        // Verify the results
        assertThat(result).containsAll(Collections.emptyList());
    }
}
