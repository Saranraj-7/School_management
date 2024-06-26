package com.Fyndus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Fyndus.DTO.SignUpDTO;
import com.Fyndus.entity.Login;
import com.Fyndus.respository.LoginRepository;
import com.example.demo.Utils.Role;

@Service
public class LoginService {

	@Autowired LoginRepository loginRepository;
	
	@Autowired PasswordEncoder passwordEncoder;
	
	public Login SignUp(SignUpDTO signUpDTO) {
		Login user = new Login();
		user.setEmail(signUpDTO.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
		user.setRole(Role.USER);
		return loginRepository.save(user);
	}
	
	public Login adminSignUp(SignUpDTO signUpDTO) {
		Login user = new Login();
		user.setEmail(signUpDTO.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
		user.setRole(Role.ADMIN);
		return loginRepository.save(user);
	}

	

		
}
