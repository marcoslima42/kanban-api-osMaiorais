package com.bracme.kanban.kanban.enums;

import com.bracme.kanban.kanban.constants.ExceptionMessages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskState {
	TO_DO(0, "to do"),
	DOING(1, "doing"),
	DONE(2, "done");

	private final Integer state;
	private final String description;

	public static TaskState toEnum(@NonNull Integer state) throws IllegalAccessException {
		for(var value: TaskState.values()) {
			if (value.getState().equals(state))
				return value;
		}

		throw new IllegalAccessException(ExceptionMessages.INVALID_ENUM_ERROR_MESSAGE);
	}
}
