package com.bracme.kanban.kanban.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bracme.kanban.kanban.dtos.responses.CustomerResponseDto;
import com.bracme.kanban.kanban.services.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	private final CustomerService customerService;

	@GetMapping("")
	@Operation(summary = "Returns a list of all customers")
	public ResponseEntity<Page<CustomerResponseDto>> getAll(
		@RequestParam(name = "page", defaultValue = "0") Integer page,
		@RequestParam(name = "size", defaultValue = "20") Integer size,
		@RequestParam(name = "orderBy", defaultValue = "createdAt") String orderBy,
		@RequestParam(name = "direction", defaultValue = "ASC") String direction
	) {
		var response = customerService.getAll(page, size, orderBy, direction);
		log.info("Response: {}", response);
		return ResponseEntity.ok(response);
	}
}
