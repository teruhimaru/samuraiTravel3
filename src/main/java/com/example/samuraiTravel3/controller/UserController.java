package com.example.samuraiTravel3.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.samuraiTravel3.entity.User;
import com.example.samuraiTravel3.repository.UserRepository;
import com.example.samuraiTravel3.security.UserDetailsImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			Model model
			) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		
		model.addAttribute("user", user);
		
		return "user/index";
	}
}
