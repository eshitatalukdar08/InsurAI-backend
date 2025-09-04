package com.insurAI.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "policies")
public class Policy {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 @Column(unique = true, nullable = false)
	 private String policyNumber;
	
	 @Column(nullable = false)
	 private String policyName;
	
	 private String description;
	
	 @Column(nullable = false)
	 private BigDecimal premium;
	
	 @Column(name = "created_at", updatable = false)
	 private LocalDateTime createdAt;
	
	 @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
	 private Set<UserPolicy> userPolicies;
	
	 @PrePersist
	 protected void onCreate() {
	     this.createdAt = LocalDateTime.now();
	 }
	
	 // Getters and Setters
	 public Long getId() {
	     return id;
	 }
	
	 public void setId(Long id) {
	     this.id = id;
	 }
	
	 public String getPolicyNumber() {
	     return policyNumber;
	 }
	
	 public void setPolicyNumber(String policyNumber) {
	     this.policyNumber = policyNumber;
	 }
	
	 public String getPolicyName() {
	     return policyName;
	 }
	
	 public void setPolicyName(String policyName) {
	     this.policyName = policyName;
	 }
	
	 public String getDescription() {
	     return description;
	 }
	
	 public void setDescription(String description) {
	     this.description = description;
	 }
	
	 public BigDecimal getPremium() {
	     return premium;
	 }
	
	 public void setPremium(BigDecimal premium) {
	     this.premium = premium;
	 }
	
	 public LocalDateTime getCreatedAt() {
	     return createdAt;
	 }
	
	 public void setCreatedAt(LocalDateTime createdAt) {
	     this.createdAt = createdAt;
	 }
	
	 public Set<UserPolicy> getUserPolicies() {
	     return userPolicies;
	 }
	
	 public void setUserPolicies(Set<UserPolicy> userPolicies) {
	     this.userPolicies = userPolicies;
	 }
}
