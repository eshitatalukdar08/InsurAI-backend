package com.insurAI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurAI.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
};
