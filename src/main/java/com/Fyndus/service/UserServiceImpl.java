package com.Fyndus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Fyndus.respository.LoginRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.loginRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found !!!"));
	}
}
