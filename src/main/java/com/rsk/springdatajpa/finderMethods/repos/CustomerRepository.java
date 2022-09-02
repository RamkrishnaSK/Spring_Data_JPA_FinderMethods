package com.rsk.springdatajpa.finderMethods.repos;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsk.springdatajpa.finderMethods.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByNameAndEmail(String namez, String emailz); 
	
	public List<Customer> findByEmailLike(String emailz);  
	
	public List<Customer> findByIdIn(List<Long> ids);
	
}
