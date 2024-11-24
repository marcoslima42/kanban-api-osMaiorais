package com.bracme.kanban.kanban.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bracme.kanban.kanban.dtos.requests.CreateCustomerRequestDto;
import com.bracme.kanban.kanban.entities.Customer;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CustomerMapperTest {
	@Test
	void whenMapToEntityWithNullParameter_ThenThrowException() {
		//	givEN / Assume
		CreateCustomerRequestDto dto = null;

		//	whEN / Act + thEN / Assert
		assertThrows(NullPointerException.class, () -> CustomerMapper.mapToEntity(dto));
	}
	
	@Test
	void whenMapToEntityWithCorrectParameter_ThenReturnEntity() {
		//	givEN / Assume
		CreateCustomerRequestDto dto = new CreateCustomerRequestDto("login@test.com", "123@Test");

		// whEN / Act
		var result = CustomerMapper.mapToEntity(dto);

		//	thEN / Assert
		assertNotNull(result);
		assertEquals(dto.login(), result.getLogin());
	}
	
	@Test
	void whenMapToDtoWithNullParameter_ThenThrowException() {
		//	givEN / Assume
		Customer entity = null;

		//	whEN / Act + thEN / Assert
		assertThrows(NullPointerException.class, () -> CustomerMapper.mapToDto(entity));
	}
	
	@Test
	void whenMapToDtoWithCorrectParameter_ThenThrowException() {
		//	givEN / Assume
		Customer entity = Customer
			.builder()
			.login("login@test.com")
			.password("123@Test123@123@Test123123@Test123")
			.build();

		// whEN / Act
		var result = CustomerMapper.mapToDto(entity);

		//	thEN / Assert
		assertNotNull(result);
		assertEquals(entity.getLogin(), result.login());
	}
}
