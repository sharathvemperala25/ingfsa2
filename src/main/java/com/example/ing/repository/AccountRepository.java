package com.example.ing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ing.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByAccountNumber(Integer accountNumber);
	
	@Query("select a from Account a where a.customer.customerId=?1")
	Account findByCustomer(Long customerId);

	
}
