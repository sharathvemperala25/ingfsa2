package com.example.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.ing.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

public	Customer findByLoginIdAndPassword(String loginId, String password);

}
