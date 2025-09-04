package com.insurAI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurAI.model.UserPolicy;

public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long> {
	List<UserPolicy> findByUserId(Long userId);
}
