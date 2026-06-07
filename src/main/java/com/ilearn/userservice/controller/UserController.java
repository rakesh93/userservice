package com.ilearn.userservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilearn.userservice.model.CommentDTO;
import com.ilearn.userservice.model.PostDTO;
import com.ilearn.userservice.model.ReplyDTO;
import com.ilearn.userservice.model.UserDTO;
import com.ilearn.userservice.model.UserModel;
import com.ilearn.userservice.model.VoterDTO;
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
	public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel updatedUser) {
		return userService.updateUser(id, updatedUser);
	}

	// Json file coming from local
	@GetMapping("/getUserList")
	public List<UserDTO> getUsers() throws IOException {
		return userService.getAllUsers();
	}

	// Json file coming from local
	@GetMapping("/getVoterList")
	public List<VoterDTO> getVoters() throws IOException {
		return userService.getVoters();
	}

	// Json file coming from local
	@GetMapping("/getCommentList")
	public List<CommentDTO> getCommentList() throws IOException {
		return userService.getCommentList();
	}

	// Json file coming from local
	@GetMapping("/getPostList")
	public List<PostDTO> getPostList() throws IOException {
		return userService.getPostList();
	}

	// Json file coming from local
	@GetMapping("/getReplyList")
	public List<ReplyDTO> getReplyList() throws IOException {
		return userService.getReplyList();
	}
}
