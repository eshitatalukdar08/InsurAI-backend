package com.insurAI.service;

import com.insurAI.model.Policy;
import com.insurAI.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

	 @Autowired
	 private PolicyRepository policyRepository;
	
	
	 public List<Policy> getAllPolicies() {
	     return policyRepository.findAll();
	 }
	
	 public Optional<Policy> getPolicyById(Long id) {
	     return policyRepository.findById(id);
	 }
	
	
	 public Policy createPolicy(Policy policy) {
	     return policyRepository.save(policy);
	 }
	
	 public Optional<Policy> updatePolicy(Long id, Policy policyDetails) {
	     return policyRepository.findById(id).map(policy -> {
	         policy.setPolicyName(policyDetails.getPolicyName());
	         policy.setDescription(policyDetails.getDescription());
	         policy.setPremium(policyDetails.getPremium());
	         return policyRepository.save(policy);
	     });
	 }
	
	
	 public void deletePolicy(Long id) {
	     policyRepository.deleteById(id);
	 }
}
