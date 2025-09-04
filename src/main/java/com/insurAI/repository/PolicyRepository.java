package com.insurAI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurAI.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
	Optional<Policy> findByPolicyNumber(String policyNumber);
}
