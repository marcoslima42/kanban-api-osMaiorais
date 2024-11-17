package com.bracme.kanban.kanban.entities.abstracts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	UUID id;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	LocalDateTime createdAt;

	@Column(name = "updated_at")
	@LastModifiedDate
	LocalDateTime updatedAt;
}
