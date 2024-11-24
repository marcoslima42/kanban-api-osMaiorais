package com.bracme.kanban.kanban.dtos.requests;

import jakarta.validation.constraints.Size;

public record UpdatePasswordCustomerRequestDto(
	@Size(
		min = 12,
		max = 88,
		message = "Password must be between 12 and 88 caracters")
	String password,

	@Size(
		min = 12,
		max = 88,
		message = "New Password must be between 12 and 88 caracters")
	String newPassword) {}
