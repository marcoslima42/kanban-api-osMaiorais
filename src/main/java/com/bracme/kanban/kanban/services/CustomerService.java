package com.bracme.kanban.kanban.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bracme.kanban.kanban.dtos.responses.CustomerResponseDto;
import com.bracme.kanban.kanban.entities.Customer;
import com.bracme.kanban.kanban.mappers.CustomerMapper;
import com.bracme.kanban.kanban.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public List<CustomerResponseDto> getAll() {
		List<Customer> customers = this.customerRepository.findAll();
		log.info("Customers: {}", customers);


		return customers
			.stream()
			.map(CustomerMapper::mapToDto)
			.toList();
	}

	public Page<CustomerResponseDto> getAll(Integer page, Integer size, String orderBy, String direction) {
		PageRequest pagination = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		
		Page<Customer> customers = this.customerRepository.findAll(pagination);

		log.info("Customers: {}", customers);

		return customers
			.map(CustomerMapper::mapToDto);
	}
}
