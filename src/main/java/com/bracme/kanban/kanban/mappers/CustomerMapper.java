package com.bracme.kanban.kanban.mappers;

import org.springframework.stereotype.Component;

import com.bracme.kanban.kanban.dtos.requests.CreateCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.responses.CustomerResponseDto;
import com.bracme.kanban.kanban.entities.Customer;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class CustomerMapper {
	private CustomerMapper() {
	}

	public static Customer mapToEntity(CreateCustomerRequestDto dto) {
		if (dto == null) {
			log.warn("CreateCustomerRequestDto null");
			return null;
		}

		return Customer
			.builder()
			.login(dto.login())
			.password(dto.password())
			.build();
	}

	public static CustomerResponseDto mapToDto(Customer c) {
		if (c == null) {
			log.warn("Customer null");
			return null;
		}

		return new CustomerResponseDto(
			c.getId(),
			c.getLogin(),
			c.getCreatedAt(),
			c.getUpdatedAt());
	}
}
