package com.bracme.kanban.kanban.enums;

import com.bracme.kanban.kanban.constants.ExceptionMessages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskPriority {
	NOT_URGENT_AND_NOT_IMPORTANT(0,"not urgent and not important"),
	NOT_URGENT_AND_IMPORTANT(1, "not urgent and important"),
	URGENT_AND_NOT_IMPORTANT(2, "urgent and not important"),
	URGENT_AND_IMPORTANT(3, "urgent and important");

	private final Integer priority;
	private final String description;

	public static TaskPriority toEnum(@NonNull Integer priority) throws IllegalAccessException {
		for(var value: TaskPriority.values()) {
			if (value.getPriority().equals(priority))
				return value;
		}

		throw new IllegalAccessException(ExceptionMessages.INVALID_ENUM_ERROR_MESSAGE);
	}
}
