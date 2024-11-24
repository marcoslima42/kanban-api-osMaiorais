package com.bracme.kanban.kanban.dtos.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateCustomerRequestDto(
	@NotNull(
		message = "Login is required")
	@Size(
		max = 88,
		message = "Login must be less or equals than 88 caracters")
	String login,

	@Size(
		min = 12,
		max = 88,
		message = "Password must be between 12 and 88 caracters")
	String password) {}
