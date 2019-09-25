package com.example.ing.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.ing.dto.CustomerDetailsDto;
import com.example.ing.dto.CustomerDto;
import com.example.ing.entity.Account;
import com.example.ing.entity.Customer;
import com.example.ing.service.ICustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	ICustomerService customerService;

	CustomerDto customerDto = null;
	CustomerDetailsDto customerDetailsDto = null;
	Customer customer = null;
	Account account = null;

	@Test
	public void registerCustomerTest() throws Exception {
		customerDto = new CustomerDto();
		customerDto.setFirstName("Lakshmi");
		customerDto.setEmail("mpl@gmail.com");
		customerDto.setPassword("manne123");
		customerDto.setConfirmPassword("manne123");

		customer = new Customer();
		customer.setCustomerId(1L);

		account = new Account();
		account.setAccountType("SA");

		customerDetailsDto = new CustomerDetailsDto();
		customerDetailsDto.setMessage("You have Successfully Registered.....");

		Mockito.when(customerService.register(customerDto)).thenReturn(customerDetailsDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/register").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(customerDetailsDto))).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
