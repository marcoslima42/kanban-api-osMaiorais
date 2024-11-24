package com.bracme.kanban.kanban.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bracme.kanban.kanban.dtos.requests.CreateCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.requests.UpdateCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.requests.UpdatePasswordCustomerRequestDto;
import com.bracme.kanban.kanban.dtos.responses.CustomerResponseDto;
import com.bracme.kanban.kanban.services.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
//	http://localhost:8080/customers
public class CustomerController {
	private final CustomerService customerService;

	//	http://localhost:8080/customers?page=20&size=1&orderBy=updatedAt&direction=DESC
	@GetMapping("")
	@Operation(summary = "Returns a list of all customers with pagination")
	public ResponseEntity<Page<CustomerResponseDto>> getAll(
		@RequestParam(name = "page", defaultValue = "0") Integer page,
		@RequestParam(name = "size", defaultValue = "20") Integer size,
		@RequestParam(name = "orderBy", defaultValue = "createdAt") String orderBy,
		@RequestParam(name = "direction", defaultValue = "ASC") String direction) {
			
			return ResponseEntity.ok(customerService.getAll(page, size, orderBy, direction));
		}
		
	//	http://localhost:8080/customers/5fc0e2ea-6566-4fdc-89e2-44ed8d0dfb3e
	@GetMapping("/{id}")
	@Operation(summary = "Return one customer, by it's Id")
	public ResponseEntity<CustomerResponseDto> getById(
		@PathVariable(name = "id") UUID id) {
			
		return ResponseEntity.ok(customerService.getById(id));
	}

	//	http://localhost:8080/customers
	@PostMapping("")
	@Operation(summary = "Create a new customer")
	public ResponseEntity<CustomerResponseDto> create(
		@Valid @RequestBody CreateCustomerRequestDto dto) {

		return ResponseEntity.ok(customerService.create(dto));
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update all fields of one customer, by it's Id")
	public ResponseEntity<Void> updateById(
		@PathVariable(name = "id") UUID id,
		@RequestBody UpdateCustomerRequestDto dto) {
		
		customerService.updateById(id, dto);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete one customer, by it's Id")
	public ResponseEntity<Void> deleteById(
		@PathVariable(name = "id") UUID id) {

		customerService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{id}/update-password")
	@Operation(summary = "Updates one customer's password, by it's Id")
	public ResponseEntity<Void> updatePasswordById(
		@PathVariable(name = "id") UUID id,
		@RequestBody UpdatePasswordCustomerRequestDto dto) {

		customerService.updatePasswordById(id, dto);
		return ResponseEntity.ok(null);
	}
}
