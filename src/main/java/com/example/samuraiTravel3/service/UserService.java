package com.example.samuraiTravel3.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraiTravel3.entity.Role;
import com.example.samuraiTravel3.entity.User;
import com.example.samuraiTravel3.form.SignupForm;
import com.example.samuraiTravel3.repository.RoleRepository;
import com.example.samuraiTravel3.repository.UserRepository;

@Service
public class UserService {
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(RoleRepository roleRepository,
			UserRepository userRepository,
			PasswordEncoder passwordEncoder
			) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public User create(SignupForm signupForm) {
		Role role = roleRepository.findByName("ROLE_GENERAL");
		User user = new User();
		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setPostalCode(signupForm.getPostalCode());
		user.setAddress(signupForm.getAddress());
		user.setPhoneNumber(signupForm.getPhoneNumber());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.setRole(role);
		user.setEnabled(false);
		
		return userRepository.save(user);
	}
	
	public Boolean isEmailRegistered(SignupForm signupForm) {
		Boolean exist = userRepository.findByEmail(signupForm.getEmail()) != null;
		return exist;
		
	}
	
	public Boolean isSamePassword(String password,
			String passwordConfirmation
			) {
		Boolean match;
		if (password.equals(passwordConfirmation)) {
			match = true;
		} else {
			match = false;
		}
		
		return !match;
		
	}
	
	@Transactional
	public void enableUser(User user) {
		user.setEnabled(true);
		userRepository.save(user);
	}
}
