package com.bracme.kanban.kanban.mappers;

import org.springframework.stereotype.Component;

import com.bracme.kanban.kanban.dtos.requests.CreateCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.responses.CustomerResponseDto;
import com.bracme.kanban.kanban.entities.Customer;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class CustomerMapper {
	private CustomerMapper() {
	}

	public static Customer mapToEntity(@NonNull CreateCustomerRequestDto dto) {
		log.info("Dto to map: {}", dto);

		return Customer
		.builder()
		.login(dto.login())
		.password(dto.password())
		.build();
	}
	
	public static CustomerResponseDto mapToDto(@NonNull Customer c) {
		log.info("Customer to map: {}", c);

		return new CustomerResponseDto(
			c.getId(),
			c.getLogin(),
			c.getCreatedAt(),
			c.getUpdatedAt());
	}
}
