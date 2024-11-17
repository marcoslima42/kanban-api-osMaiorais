package com.bracme.kanban.kanban.entities;

import com.bracme.kanban.kanban.entities.abstracts.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "Customer")
public class Customer extends BaseEntity {
	@Column(name = "login", nullable = false, unique = true)
	String login;

	@Column(name = "password", nullable = false)
	String password;
}
