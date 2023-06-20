package com.softwaretesting.testing.customerRegistration.controller;
import com.softwaretesting.testing.customerRegistration.service.CustomerRegistrationService;
import com.softwaretesting.testing.model.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.then;

@WebMvcTest(CustomerRegistrationController.class)
class CustomerRegistrationControllerIntegrationTest {
    @MockBean
    CustomerRegistrationService customerRegistrationService;
    @Autowired
    public MockMvc mockMvc;
    @Test
    void shouldCreateMockMvc(){
        assertNotNull(mockMvc);
    }
    @Captor
    ArgumentCaptor<Customer> argumentCustomerCaptor;

    @Test
    void itShouldAddTheRightCustomer() throws Exception {
        Customer c1 = new Customer(1l,"tim","tim","123");
        String jsonCustomer= "{\"userName\": \"tim\",\"name\": \"tim\",\"phoneNumber\": \"123\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customer-registration").contentType(MediaType.APPLICATION_JSON).content(jsonCustomer));
        then(customerRegistrationService).should().registerNewCustomer(argumentCustomerCaptor.capture());
        assertEquals(argumentCustomerCaptor.getValue().getUserName(),c1.getUserName());
    }
}