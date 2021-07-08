package com.codewithkaif.usersignupsignin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkaif.usersignupsignin.entity.User;
import com.codewithkaif.usersignupsignin.reposiotry.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/signup")
	public ResponseEntity<Object> addNewUser(@RequestBody User user) {

		Optional<User> optional = userRepository.findByUserName(user.getUserName());

		if (optional.isPresent()) {
			return ResponseEntity.status(400).body("Username is already exist");
		} else {
			user.setId(user.getId());
			user.setCreatedDate(user.getCreatedDate());
			userRepository.save(user);
			return ResponseEntity.status(200).body(user);
		}

	}

	// here i'm getting the user by userId.
	@GetMapping("user/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.status(200).body(optional.get());
		}
		return ResponseEntity.status(404).body("user not found");
	}

	// here i'm getting the user by username and password.
	@GetMapping("signin/userName/{userName}/password/{password}")
	public ResponseEntity<Object> getByNameAndPassword(@PathVariable String userName, @PathVariable String password) {
		Optional<User> optional = userRepository.findByUserNameAndPassword(userName, password);
		if (optional.isPresent()) {
			return ResponseEntity.status(200).body(optional.get());
		}
		return ResponseEntity.status(404).body("user not found");
	}

	@PutMapping("/user")
	public ResponseEntity<Object> changePassword(@RequestBody User updateUser) {

		Optional<User> optional = userRepository.findByUserName(updateUser.getUserName());
		if (optional.isPresent()) {

			User prevoiusUser = optional.get();

			if (prevoiusUser.getPassword().equals(prevoiusUser.getPassword())) {
				prevoiusUser.setUserName(updateUser.getUserName());
				prevoiusUser.setEmail(updateUser.getEmail());
				prevoiusUser.setMobileNumber(updateUser.getMobileNumber());
				prevoiusUser.setPassword(updateUser.getMobileNumber());
				prevoiusUser.setAge(updateUser.getAge());
				prevoiusUser.setGender(updateUser.getGender());
				prevoiusUser.setCreatedDate(updateUser.getCreatedDate());
				userRepository.save(prevoiusUser);
				return ResponseEntity.status(200).body(prevoiusUser);
			}

		}
		return ResponseEntity.status(404).body("user not found");
	}

}
