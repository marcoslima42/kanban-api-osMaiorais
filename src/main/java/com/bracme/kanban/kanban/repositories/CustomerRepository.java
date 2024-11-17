package com.bracme.kanban.kanban.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bracme.kanban.kanban.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
