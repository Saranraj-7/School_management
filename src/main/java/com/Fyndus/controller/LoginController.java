package com.Fyndus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Fyndus.DTO.SignUpDTO;
import com.Fyndus.entity.Login;
import com.Fyndus.service.LoginService;
import com.example.demo.Dto.SignInRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/signup")
	public ResponseEntity<Login> signUp(@RequestBody SignUpDTO signUpDTO) {
		
		return ResponseEntity.ok(loginService.signUp(signUpDTO));
	}

	@PostMapping("/principalSignup")
	public ResponseEntity<Login> principalSignup(@RequestBody SignUpDTO signUpDTO) {
		return ResponseEntity.ok(loginService.principalSignup(signUpDTO));
	}

	@PostMapping("/admin-signup")
	public ResponseEntity<Login> adminSignUp(@RequestBody SignUpDTO signUpDTO) {
		return ResponseEntity.ok(loginService.adminSignUp(signUpDTO));
	}

	@PostMapping("/teacher-signup")
	public ResponseEntity<Login> teacherSignup(@RequestBody SignUpDTO signUpDTO) {
		return ResponseEntity.ok(loginService.teacherSignup(signUpDTO));
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody SignInRequest signInRequest) {
		if (!StringUtils.hasText(signInRequest.getEmail())) {
			return ResponseEntity.badRequest().body("Enter email id");
		}
		if (!StringUtils.hasText(signInRequest.getPassword())) {
			return ResponseEntity.badRequest().body("Enter Password");
		}
		try {
			return ResponseEntity.ok(loginService.signIn(signInRequest));
		} catch (IllegalArgumentException | UsernameNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
