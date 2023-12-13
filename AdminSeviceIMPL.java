package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.AdminLogin;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepo;
import com.example.demo.response.Login;
@Service
public class AdminSeviceIMPL implements AdminService{
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public String addAdmin(AdminDTO adminDTO) {
		Admin admin=new Admin(
				adminDTO.getId(),
				adminDTO.getUserName(),
				this.passwordEncoder.encode(adminDTO.getPassword()));
		adminRepo.save(admin);
		return admin.getUserName();
	}
	AdminDTO adminDTO;
	@Override
	public Login loginAdmin(AdminLogin adminLogin) {		
		Admin admin1=adminRepo.findByUserName(adminLogin.getUserName());
		if(admin1!=null)
		{
			String password=adminLogin.getPassword();
			String encodedPassword=admin1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight)
			{
				Optional<Admin>admin=adminRepo.findByUserNameAndPassword(adminLogin.getUserName(), encodedPassword);
				if(admin.isPresent())
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
			return new Login("Username Not Exist",false);
		}
	}

}
