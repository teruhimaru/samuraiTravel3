package com.example.samuraiTravel3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraiTravel3.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
}
