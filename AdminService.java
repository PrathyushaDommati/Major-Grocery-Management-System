package com.example.demo.service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.AdminLogin;
import com.example.demo.response.Login;

public interface AdminService {
	String addAdmin(AdminDTO adminDTO);
	public Login loginAdmin(AdminLogin adminLogin);
}
