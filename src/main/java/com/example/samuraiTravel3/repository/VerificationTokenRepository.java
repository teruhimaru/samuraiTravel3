package com.example.samuraiTravel3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraiTravel3.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	public VerificationToken findByToken(String token);
}
