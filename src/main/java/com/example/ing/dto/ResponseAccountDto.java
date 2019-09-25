
package com.example.ing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAccountDto {
	private Long accountId;
	private Integer accountNumber;
	private double balance;
	private String accountType;
}