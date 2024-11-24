package com.bracme.kanban.kanban.enums;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TaskStateTest {
	@Test
	void whenToEnumWithCorrectParameter_ThenReturnState() {
		//	givEN / Arrange
		List<Integer> priorities = Arrays.asList(0, 1, 2);

		//	whEN / Act + thEN / Assert
		assertTrue(priorities.stream().allMatch(priority -> {
			try {
				return !TaskState.toEnum(priority).equals(null);
			} catch (IllegalAccessException e) {
				return false;
			}
		}));
	}

	@Test
	void whenToEnumWithNullParameter_ThenThrowException() {
		//	givEN / Arrange
		Integer invalidPriority = null;

		//	whEN / Act + thEN / Assert
		assertThrows(NullPointerException.class, () -> TaskState.toEnum(invalidPriority));
	}

	@Test
	void whenToEnumWithWrongParameter_ThenThrowException() {
		//	givEN / Arrange
		Integer invalidPriority = -1;

		//	whEN / Act + thEN / Assert
		assertThrows(IllegalAccessException.class, () -> TaskState.toEnum(invalidPriority));
	}
}
