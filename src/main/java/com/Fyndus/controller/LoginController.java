package com.Fyndus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fyndus.DTO.SignUpDTO;
import com.Fyndus.entity.Login;
import com.Fyndus.service.LoginService;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {

	@Autowired LoginService loginService;
	
	 @PostMapping("/signup")
	    public ResponseEntity<Login> signUp(@RequestBody SignUpDTO signUpDTO) {
	        return ResponseEntity.ok(loginService.SignUp(signUpDTO));
	    }
	 
	 
	 @PostMapping("/admin-signup")
	    public ResponseEntity<Login> adminSignUp(@RequestBody SignUpDTO signUpDTO) {
	        return ResponseEntity.ok(loginService.adminSignUp(signUpDTO));
	    }
}
