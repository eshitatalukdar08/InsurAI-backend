package com.insurAI.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_policies")
public class UserPolicy {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id", nullable = false)
	 private User user;
	
	 @ManyToOne
	 @JoinColumn(name = "policy_id", nullable = false)
	 private Policy policy;
	
	 @Column(nullable = false)
	 private LocalDate purchaseDate;
	
	 @Column(nullable = false)
	 private LocalDate expiryDate;
	
	 @Column(nullable = false)
	 private Boolean isActive;
	
	 // Getters and Setters
	 public Long getId() {
	     return id;
	 }
	
	 public void setId(Long id) {
	     this.id = id;
	 }
	
	 public User getUser() {
	     return user;
	 }
	
	 public void setUser(User user) {
	     this.user = user;
	 }
	
	 public Policy getPolicy() {
	     return policy;
	 }
	
	 public void setPolicy(Policy policy) {
	     this.policy = policy;
	 }
	
	 public LocalDate getPurchaseDate() {
	     return purchaseDate;
	 }
	
	 public void setPurchaseDate(LocalDate purchaseDate) {
	     this.purchaseDate = purchaseDate;
	 }
	
	 public LocalDate getExpiryDate() {
	     return expiryDate;
	 }
	
	 public void setExpiryDate(LocalDate expiryDate) {
	     this.expiryDate = expiryDate;
	 }
	
	 public Boolean getActive() {
	     return isActive;
	 }
	
	 public void setActive(Boolean active) {
	     isActive = active;
	 }
}
