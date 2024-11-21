package com.bracme.kanban.kanban.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bracme.kanban.kanban.entities.Customer;
import com.bracme.kanban.kanban.repositories.CustomerRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	@BeforeEach
	public void setUp() {
		customerService = new CustomerService(customerRepository);
	}
	
	@Test
	public void whenGetAllWithoutParameters_ThenReturnList () {
		//	givEN / Arrange
		var customer = Customer
			.builder()
			.login("test@mail.com")
			.build();
		
		List<Customer> customers = Arrays.asList(customer, customer, customer, customer);
		
		//	whEN / Act
		when(customerRepository.findAll()).thenReturn(customers);

		var result = customerService.getAll();

		//	thEN / Assert
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertTrue(result.stream().allMatch(c -> c.login().equalsIgnoreCase("test@mail.com")));
	}
}
