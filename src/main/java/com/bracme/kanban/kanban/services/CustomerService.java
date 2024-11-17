package com.bracme.kanban.kanban.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bracme.kanban.kanban.dtos.responses.CustomerResponseDto;
import com.bracme.kanban.kanban.entities.Customer;
import com.bracme.kanban.kanban.mappers.CustomerMapper;
import com.bracme.kanban.kanban.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public List<CustomerResponseDto> findAll(Pageable pageable) {
		Page<Customer> customers = this.customerRepository.findAll(pageable);

		return customers
			.stream()
			.map(CustomerMapper::mapToDto)
			.toList();
	}
}
