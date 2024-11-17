package com.bracme.kanban.kanban.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@GetMapping("test")
	@Operation(summary = "Returns a hello world string")
	public String getTest() {
		return "Hello World!";
	}
}
