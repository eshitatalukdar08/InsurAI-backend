package com.insurAI.controller;



import com.insurAI.model.User;
import com.insurAI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

	 @Autowired
	 private UserService userService;
	
	 @GetMapping("/{id}")
	 public ResponseEntity<User> getUserById(@PathVariable Long id) {
	     Optional<User> user = userService.getUserById(id);
	     return user.map(ResponseEntity::ok)
	                .orElseGet(() -> ResponseEntity.notFound().build());
	 }
	
	 @PostMapping
	 public ResponseEntity<User> createUser(@RequestBody User user) {
	     User createdUser = userService.saveUser(user);
	     return ResponseEntity.ok(createdUser);
	 }
	
	 @PutMapping("/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
	     Optional<User> existingUser = userService.getUserById(id);
	     if (existingUser.isPresent()) {
	         userDetails.setId(id);
	         User updatedUser = userService.saveUser(userDetails);
	         return ResponseEntity.ok(updatedUser);
	     } else {
	         return ResponseEntity.notFound().build();
	     }
	 }
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	     userService.deleteUser(id);
	     return ResponseEntity.noContent().build();
	 }
}
