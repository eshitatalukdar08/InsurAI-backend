package com.insurAI.controller;


import com.insurAI.model.UserPolicy;
import com.insurAI.service.UserPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-policies")
public class UserPolicyController {

    @Autowired
    private UserPolicyService userPolicyService;

    @GetMapping("/user/{userId}")
    public List<UserPolicy> getUserPolicies(@PathVariable Long userId) {
        return userPolicyService.getUserPolicies(userId);
    }

    @PostMapping
    public ResponseEntity<UserPolicy> purchasePolicy(@RequestBody UserPolicy userPolicy) {
        UserPolicy newPurchase = userPolicyService.saveUserPolicy(userPolicy);
        return ResponseEntity.ok(newPurchase);
    }

    @PutMapping("/{id}/renew")
    public ResponseEntity<UserPolicy> renewPolicy(@PathVariable Long id, @RequestParam @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) LocalDate newExpiryDate) {
        Optional<UserPolicy> renewedPolicy = userPolicyService.renewPolicy(id, newExpiryDate);
        return renewedPolicy.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserPolicy(@PathVariable Long id) {
        userPolicyService.deleteUserPolicy(id);
        return ResponseEntity.noContent().build();
    }
}

