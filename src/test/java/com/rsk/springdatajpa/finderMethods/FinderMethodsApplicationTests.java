package com.rsk.springdatajpa.finderMethods;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rsk.springdatajpa.finderMethods.entities.Customer;
import com.rsk.springdatajpa.finderMethods.repos.CustomerRepository;

@SpringBootTest
class FinderMethodsApplicationTests {

	@Autowired
	private CustomerRepository repo;

	// Find all Customers whose name is Bharath and email is bharatt@gmail.com
	@Test
	public void testFindByNameAndEmail() {
		List<Customer> list = repo.findByNameAndEmail("Bharath", "bharatt@gmail.com");
		for (Customer c : list) {
			System.out.println("Id : " + c.getId()); // 1,8
		}
	}

	// Find all Customers whose email have suffix @hotmail.com
	@Test
	public void testLike() {
		List<Customer> list = repo.findByEmailLike("%@hotmail.com%");
		for (Customer c : list) {
			System.out.println(c.getId()); // 5,6,7
		}
	}

	// Find Customers provided ids 2,4,6
	@Test
	public void testIn() {
		System.out.println("Customers Info whose ID's are 2, 4, 6");
		System.out.println("=======================================");
		List<Customer> list = repo.findByIdIn(Arrays.asList(2l, 4l, 6l));
		for (Customer c : list) {
			System.out.println("Id : " + c.getId());
			System.out.println("Name : " + c.getName()); 
			System.out.println("Email : " + c.getEmail());
			System.out.println("-------------------------------");
		}
	}

}
