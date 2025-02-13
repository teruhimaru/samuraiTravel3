package com.example.samuraiTravel3.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraiTravel3.entity.Role;
import com.example.samuraiTravel3.entity.User;
import com.example.samuraiTravel3.form.SignupForm;
import com.example.samuraiTravel3.form.UserEditForm;
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
	
	@Transactional
	public void update(UserEditForm userEditForm) {
		User user = userRepository.getReferenceById(userEditForm.getId());
		user.setName(userEditForm.getName());
		user.setFurigana(userEditForm.getFurigana());
		user.setPostalCode(userEditForm.getPostalCode());
		user.setAddress(userEditForm.getAddress());
		user.setPhoneNumber(userEditForm.getPhoneNumber());
		user.setEmail(userEditForm.getEmail());
		userRepository.save(user);
	}
	
	public Boolean isEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);
		return user != null;
		
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
	
	public boolean isEmailChanged(UserEditForm userEditForm) {
		User currentUser = userRepository.getReferenceById(userEditForm.getId());
		return !userEditForm.getEmail().equals(currentUser.getEmail());
	}
}
