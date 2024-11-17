package com.bracme.kanban.kanban.dtos.responses;

import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerResponseDto(
	UUID id,
	String login,
	LocalDateTime createdAt,
	LocalDateTime updatedAt) {
}
