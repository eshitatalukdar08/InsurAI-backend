package com.insurAI.controller;

import com.insurAI.model.Policy;
import com.insurAI.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

	 @Autowired
	 private PolicyService policyService;
	
	 @GetMapping
	 public List<Policy> getAllPolicies() {
	     return policyService.getAllPolicies();
	 }
	
	
	 @GetMapping("/{id}")
	 public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
	     Optional<Policy> policy = policyService.getPolicyById(id);
	     return policy.map(ResponseEntity::ok)
	                  .orElseGet(() -> ResponseEntity.notFound().build());
	 }
	
	
	 @PostMapping
	 public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
	     Policy createdPolicy = policyService.createPolicy(policy);
	     return ResponseEntity.ok(createdPolicy);
	 }
	
	 @PutMapping("/{id}")
	 public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody Policy policyDetails) {
	     Optional<Policy> updatedPolicy = policyService.updatePolicy(id, policyDetails);
	     return updatedPolicy.map(ResponseEntity::ok)
	                         .orElseGet(() -> ResponseEntity.notFound().build());
	 }
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
	     policyService.deletePolicy(id);
	     return ResponseEntity.noContent().build();
	 }
}
