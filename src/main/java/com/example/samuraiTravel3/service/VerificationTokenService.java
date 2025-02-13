package com.example.samuraiTravel3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.samuraiTravel3.entity.User;
import com.example.samuraiTravel3.entity.VerificationToken;
import com.example.samuraiTravel3.repository.VerificationTokenRepository;


@Service
public class VerificationTokenService {
	private final VerificationTokenRepository verificationTokenRepository;
	
	public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
		this.verificationTokenRepository = verificationTokenRepository;
	}
	
	@Transactional
	public void create(User user, String token) {
		VerificationToken verificationToken = new VerificationToken();
		
		verificationToken.setUser(user);
		verificationToken.setToken(token);
		
		verificationTokenRepository.save(verificationToken);
	}
	
	public VerificationToken getVerificationToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}
}
