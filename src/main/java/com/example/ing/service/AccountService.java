package com.example.ing.service;

import com.example.ing.dto.ResponseAccountDto;

public interface AccountService {

	ResponseAccountDto getAccountSummary(Integer accountNumber);

}
