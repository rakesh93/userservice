package com.ilearn.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ilearn.userservice.model.UserModel;
import com.ilearn.userservice.repository.UserRepository;
import com.ilearn.userservice.service.UserService;

@RestController
@RequestMapping("/user-service")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list/{role}")
	public List<UserModel> getUsersByRole(@PathVariable String role) {
	    return userRepository.findByUserRole(role);
	}
	
	@PostMapping("/create")
	public UserModel createUser(@RequestBody UserModel userModel) {
		return userRepository.save(userModel);
	}
	
	@PutMapping("/update/{id}")
    public UserModel updateUser(@PathVariable Long id,
                                @RequestBody UserModel updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
	
}
