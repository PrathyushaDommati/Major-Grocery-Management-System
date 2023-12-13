package com.example.demo.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.response.Login;
import com.example.demo.service.CustomerService;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")

public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping(path="/register")
	public String saveCustomer(@RequestBody CustomerDTO customerDTO)
	{
		String id=customerService.addCustomer(customerDTO);
		return id;
	}
	@PostMapping(path="/login")
	public ResponseEntity<?>loginCustomer(@RequestBody LoginDTO loginDTO)
	{
		Login login=customerService.loginCustomer(loginDTO);
		return ResponseEntity.ok(login);
	}
	
}