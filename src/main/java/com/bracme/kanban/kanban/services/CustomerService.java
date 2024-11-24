package com.bracme.kanban.kanban.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bracme.kanban.kanban.constants.LogMessages;
import com.bracme.kanban.kanban.dtos.requests.CreateCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.requests.UpdateCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.requests.UpdatePasswordCustomerRequestDto;
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

	public Page<CustomerResponseDto> getAll(Integer page, Integer size, String orderBy, String direction) {
		log.info("{} Customer Service - getAll", LogMessages.START_LOG_MESSAGE);

		PageRequest pagination = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		Page<Customer> customers = this.customerRepository.findAll(pagination);
		log.info("Customers: {}", customers);

		log.info("{} Customer Service - getAll", LogMessages.SUCESSFUL_FINISH_LOG_MESSAGE);

		return customers
			.map(CustomerMapper::mapToDto);
	}

	public CustomerResponseDto getById(UUID id) {
		log.info("{} Customer Service - getById", LogMessages.START_LOG_MESSAGE);
		
		Customer customer = this.customerRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Customer not found"));

		log.info("Customer: {}", customer);
		
		log.info("{} Customer Service - getById", LogMessages.SUCESSFUL_FINISH_LOG_MESSAGE);
		return CustomerMapper.mapToDto(customer);
	}
	
	public CustomerResponseDto create(CreateCustomerRequestDto dto) {
		log.info("{} Customer Service - create", LogMessages.START_LOG_MESSAGE);
		Customer customer = CustomerMapper.mapToEntity(dto);
		
		customer = this.customerRepository.save(customer);
		log.info("Customer: {}", customer);
		
		log.info("{} Customer Service - create", LogMessages.SUCESSFUL_FINISH_LOG_MESSAGE);
		return CustomerMapper.mapToDto(customer);
	}

	public void updateById(UUID id, UpdateCustomerRequestDto dto) {
		log.info("{} Customer Service - updateById", LogMessages.START_LOG_MESSAGE);

		Customer customer = this.customerRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Customer not found"));
		
		if (dto.login() != null) {
			customer.setLogin(dto.login());
		}
		if (dto.password() != null) {
			customer.setPassword(dto.password());
		}

		this.customerRepository.save(customer);
		log.info("Customer: {}", customer);

		log.info("{} Customer Service - updateById", LogMessages.SUCESSFUL_FINISH_LOG_MESSAGE);
		return;
	}

	public void deleteById(UUID id) {
		log.info("{} Customer Service - deleteById", LogMessages.START_LOG_MESSAGE);
		this.customerRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Customer not found"));

			this.customerRepository.deleteById(id);

			log.info("{} Customer Service - deleteById", LogMessages.SUCESSFUL_FINISH_LOG_MESSAGE);
		return;
	}

	public void updatePasswordById(UUID id, UpdatePasswordCustomerRequestDto dto) {
		log.info("{} Customer Service - updatePasswordById", LogMessages.START_LOG_MESSAGE);

		Customer customer = this.customerRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Customer not found"));

		if(dto.password() != null && customer.getPassword().equals(dto.password())) {
			customer.setPassword(dto.newPassword());
			this.customerRepository.save(customer);
		}

		log.info("{} Customer Service - updatePasswordById", LogMessages.SUCESSFUL_FINISH_LOG_MESSAGE);
		return;
	}
}
