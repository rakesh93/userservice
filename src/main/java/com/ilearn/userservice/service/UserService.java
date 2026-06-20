package com.ilearn.userservice.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ilearn.userservice.exception.UserNotFoundException;
import com.ilearn.userservice.kafka.UserKafkaProducer;
import com.ilearn.userservice.model.CommentDTO;
import com.ilearn.userservice.model.PostDTO;
import com.ilearn.userservice.model.ReplyDTO;
import com.ilearn.userservice.model.UserCreatedEvent;
import com.ilearn.userservice.model.UserDTO;
import com.ilearn.userservice.model.UserModel;
import com.ilearn.userservice.model.VoterDTO;
import com.ilearn.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserKafkaProducer userKafkaProducer;

	private final ObjectMapper objectMapper = new ObjectMapper();

	public UserModel createUser(UserModel userModel) {
		UserModel savedUser = userRepository.save(userModel);
		userKafkaProducer.sendMessage("Successfully Created this User : " + savedUser.getFirstName() + savedUser.getLastName());
		userKafkaProducer.publish(new UserCreatedEvent(savedUser.getId(),savedUser.getFirstName()));

		return savedUser;
	}

	public List<UserModel> getUsersIfRole(String role) {
		if (role == null || role.isBlank()) {
			return userRepository.findAll();
		}
		List<UserModel> users = userRepository.findByUserRole(role);
		if (users.isEmpty()) {
			throw new UserNotFoundException("No users found with this role : " + role);
		}

		return users;
	}

	public UserModel updateUser(Long id, UserModel userModel) {

		UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmailId(userModel.getEmailId());
		user.setMobileNo(userModel.getMobileNo());
		user.setUserRole(userModel.getUserRole());
		return userRepository.save(user);
	}

	// Json file coming from local
	public List<UserDTO> getAllUsers() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.json");
		return Arrays.asList(objectMapper.readValue(inputStream, UserDTO[].class));
	}

	// Json file coming from local
	public List<VoterDTO> getVoters() throws IOException {
		objectMapper.registerModule(new JavaTimeModule());
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("votes.json");
		return Arrays.asList(objectMapper.readValue(inputStream, VoterDTO[].class));
	}

	// Json file coming from local
	public List<CommentDTO> getCommentList() throws IOException {
		objectMapper.registerModule(new JavaTimeModule());
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("comments.json");
		return Arrays.asList(objectMapper.readValue(inputStream, CommentDTO[].class));
	}

	// Json file coming from local
	public List<PostDTO> getPostList() throws IOException {
		objectMapper.registerModule(new JavaTimeModule());
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("posts.json");
		return Arrays.asList(objectMapper.readValue(inputStream, PostDTO[].class));
	}

	// Json file coming from local
	public List<ReplyDTO> getReplyList() throws IOException {
		objectMapper.registerModule(new JavaTimeModule());
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("replies.json");
		return Arrays.asList(objectMapper.readValue(inputStream, ReplyDTO[].class));
	}
}
