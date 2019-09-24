package com.example.ing.service;

import com.example.ing.dto.CustomerDetailsDto;
import com.example.ing.dto.CustomerDto;

public interface ICustomerService {

	public CustomerDetailsDto register(CustomerDto customerDto);
}
