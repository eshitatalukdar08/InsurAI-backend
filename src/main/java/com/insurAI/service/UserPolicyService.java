package com.insurAI.service;

import com.insurAI.model.UserPolicy;
import com.insurAI.repository.UserPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserPolicyService {

	 @Autowired
	 private UserPolicyRepository userPolicyRepository;
	
	
	 public List<UserPolicy> getUserPolicies(Long userId) {
	     return userPolicyRepository.findByUserId(userId);
	 }
	
	 public UserPolicy saveUserPolicy(UserPolicy userPolicy) {
	     return userPolicyRepository.save(userPolicy);
	 }
	
	 public void deleteUserPolicy(Long id) {
	     userPolicyRepository.deleteById(id);
	 }
	
	 public Optional<UserPolicy> renewPolicy(Long id, LocalDate newExpiryDate) {
	     return userPolicyRepository.findById(id).map(userPolicy -> {
	         userPolicy.setExpiryDate(newExpiryDate);
	         userPolicy.setActive(true);
	         return userPolicyRepository.save(userPolicy);
	     });
	 }
	
	 public void checkAndDeactivateExpiredPolicies() {
	     LocalDate today = LocalDate.now();
	     List<UserPolicy> activePolicies = userPolicyRepository.findAll();
	     for (UserPolicy userPolicy : activePolicies) {
	         if (userPolicy.getExpiryDate().isBefore(today) && userPolicy.getActive()) {
	             userPolicy.setActive(false);
	             userPolicyRepository.save(userPolicy);
	         }
	     }
	 }
}
