package com.bracme.kanban.kanban.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bracme.kanban.kanban.dtos.requests.CreateCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.responses.CustomerResponseDto;
import com.bracme.kanban.kanban.services.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping("")
	@Operation(summary = "Returns a list of all customers with pagination")
	public ResponseEntity<Page<CustomerResponseDto>> getAll(
		@RequestParam(name = "page", defaultValue = "0") Integer page,
		@RequestParam(name = "size", defaultValue = "20") Integer size,
		@RequestParam(name = "orderBy", defaultValue = "createdAt") String orderBy,
		@RequestParam(name = "direction", defaultValue = "ASC") String direction) {

		return ResponseEntity.ok(customerService.getAll(page, size, orderBy, direction));
	}

	@PostMapping("")
	@Operation(summary = "Create a new Customer")
	public ResponseEntity<CustomerResponseDto> postMethodName(
		@Valid @RequestBody CreateCustomerRequestDto dto) {

		return ResponseEntity.ok(new CustomerResponseDto(null, null, null, null));
	}
}
