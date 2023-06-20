package com.softwaretesting.testing.customerManagement.controller;


import com.softwaretesting.testing.customerManagement.service.CustomerManagementService;
import com.softwaretesting.testing.dao.CustomerRepository;
import com.softwaretesting.testing.exception.BadRequestException;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@WebMvcTest(CustomerManagementController.class)
class CustomerManagementControllerIntegrationTest {
    @MockBean
    public CustomerManagementService customerManagementService;
    @Autowired
    public MockMvc mockMvc;

    @Captor
    ArgumentCaptor<Customer> argumentCustomerCaptor;

    @Captor
    ArgumentCaptor<Long> argumentLongCaptor;

    @Test
    void shouldCreateMockMvc(){
        assertNotNull(mockMvc);
    }

    @Test
    void itShouldGetgetCustomerList() throws Exception {
        ArrayList<Customer> collecton = new ArrayList<Customer>();
        collecton.add(new Customer(1l,"tim","tim","123"));
        when(customerManagementService.list()).thenReturn(collecton);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers/list")).andReturn().equals(collecton);
        // mockMvc.perform(get("customers/1").content("")).andExpect(status().is(200));
    }
    @Test
    void itShouldGetRightCodeByCustomerList() throws Exception {
        ArrayList<Customer> collecton = new ArrayList<Customer>();
        collecton.add(new Customer(1l,"tim","tim","123"));
        when(customerManagementService.list()).thenReturn(collecton);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers/list")).andExpect(MockMvcResultMatchers.status().isOk());
        // mockMvc.perform(get("customers/1").content("")).andExpect(status().is(200));
    }

    @Test
    void itShouldGetCustomerById() throws Exception {
        Customer c1 = new Customer(1l,"tim","tim","123");
        when(customerManagementService.findById(any())).thenReturn(c1);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers/1")).andReturn().equals(c1);
    }

    @Test
    void itShouldGetRightCodeByCustomerById() throws Exception {
        Customer c1 = new Customer(1l,"tim","tim","123");
        when(customerManagementService.findById(any())).thenReturn(c1);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customers/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void itShouldSendTheRightCostomerToAdd() throws Exception{
        Customer c1 = new Customer(1l,"tim","tim","123");
        String jsonCustomer= "{\"userName\": \"tim\",\"name\": \"tim\",\"phoneNumber\": \"123\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers").contentType(MediaType.APPLICATION_JSON).content(jsonCustomer));
        then(customerManagementService).should().addCustomer(argumentCustomerCaptor.capture());
        assertEquals(argumentCustomerCaptor.getValue().getUserName(),c1.getUserName());
    }

    @Test
    void itShouldSendCodeIfNumberIsAllreadyUsed() throws Exception{
        Customer c1 = new Customer(1l,"tim","tim","123");
        String jsonCustomer= "{\"userName\": \"tim\",\"name\": \"tim\",\"phoneNumber\": \"123\"}";
        when(customerManagementService.addCustomer(any())).thenThrow(BadRequestException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers").contentType(MediaType.APPLICATION_JSON).content(jsonCustomer)).andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void itShouldForwardTheRightIdToDelete() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/customers/1"));
        then(customerManagementService).should().delete(argumentLongCaptor.capture());
        assertTrue(argumentLongCaptor.getValue().equals(1l));
    }

}