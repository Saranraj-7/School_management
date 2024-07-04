package com.Fyndus.service;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Fyndus.DTO.SignUpDTO;
import com.Fyndus.Utils.Role;
import com.Fyndus.entity.Login;
import com.Fyndus.exception.ErrorHandler;
import com.Fyndus.respository.LoginRepository;
import com.example.demo.Dto.JwtAuthenticationResponse;
import com.example.demo.Dto.SignInRequest;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTServiceImpl jwtServiceImpl;

	public Login signUp(SignUpDTO signUpDTO) {
		List<Login> existingUsers = loginRepository.findByemail(signUpDTO.getEmail());
		if (!existingUsers.isEmpty()) {
			throw new ErrorHandler("Email Already exists");
		}
		
	    String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).+$";
	    if (!Pattern.matches(passwordPattern, signUpDTO.getPassword())) {
	        throw new ErrorHandler("Password must contain one uppercase letter, one lowercase letter, one numeral, and one non-alphanumeric character.");
	    }

		Login user = new Login();
		user.setEmail(signUpDTO.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
		user.setRole(Role.USER);
		return loginRepository.save(user);
	}

	public Login principalSignup(SignUpDTO signUpDTO) {
		List<Login> existingUsers = loginRepository.findByemail(signUpDTO.getEmail());
		if (!existingUsers.isEmpty()) {
			throw new ErrorHandler("Email Already exists");
		}
		Login user = new Login();
		user.setEmail(signUpDTO.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
		user.setRole(Role.PRINCIPAL);
		return loginRepository.save(user);
	}

	public Login adminSignUp(SignUpDTO signUpDTO) {
		List<Login> existingUsers = loginRepository.findByemail(signUpDTO.getEmail());
		if (!existingUsers.isEmpty()) {
			throw new ErrorHandler("Email Already exists");
		}
		Login user = new Login();
		user.setEmail(signUpDTO.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
		user.setRole(Role.ADMIN);
		return loginRepository.save(user);
	}

	public Login teacherSignup(SignUpDTO signUpDTO) {
		List<Login> existingUsers = loginRepository.findByemail(signUpDTO.getEmail());
		if (!existingUsers.isEmpty()) {
			throw new ErrorHandler("Email Already exists");
		}
		Login user = new Login();
		user.setEmail(signUpDTO.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
		user.setRole(Role.TEACHER);
		return loginRepository.save(user);
	}

	public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new IllegalArgumentException("Incorrect email or password");
		}

		Login user = loginRepository.findByEmail(signInRequest.getEmail()).orElseThrow(
				() -> new UsernameNotFoundException("User not found with email: " + signInRequest.getEmail()));

		String jwt = jwtServiceImpl.generateToken(user);
		String refreshToken = jwtServiceImpl.generateRefreshToken(new HashMap<>(), user);

		JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
		jwtAuthenticationResponse.setToken(jwt);
		jwtAuthenticationResponse.setRefreshToken(refreshToken);

		return jwtAuthenticationResponse;
	}
}
