package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.response.Login;
@Service
public class CustomerServiceIMPL implements CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public String addCustomer(CustomerDTO customerDTO) {
		Customer customer=new Customer(
				customerDTO.getId(),
				customerDTO.getFirstname(),
				customerDTO.getLastName(),
			
				customerDTO.getAddress(),
				customerDTO.getEmail(),
				this.passwordEncoder.encode(customerDTO.getPassword()));
		customerRepo.save(customer);
				return customer.getFirstname();
	}
	
	CustomerDTO customerDTO;
	@Override
	public Login loginCustomer(LoginDTO loginDTO) {
		Customer customer1=customerRepo.findByEmail(loginDTO.getEmail());
		if(customer1!=null)
		{
			String password=loginDTO.getPassword();
			String encodedPassword=customer1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight)
			{
				Optional<Customer>customer=customerRepo.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
				if(customer.isPresent())
				{
					return new Login("Login Success",true);
				}
				else
				{
					return new Login("Login Failed",false);
				}
			}
			else
			{
				return new Login("Password not match",false);
			}
		}
		else
		{
			return new Login("Email Not Exist",false);
		}
	}		
}
