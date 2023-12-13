package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.LoginDTO;

import com.example.demo.response.Login;

public interface CustomerService {
	String addCustomer(CustomerDTO customerDTO);
	
	public Login loginCustomer(LoginDTO loginDTO);
}


