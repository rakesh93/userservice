package com.ilearn.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ilearn.userservice.model.UserModel;
import com.ilearn.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public UserModel updateUser(Long id, UserModel userModel) {

        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmailId(userModel.getEmailId());
        user.setMobileNo(userModel.getMobileNo());
        user.setUserRole(userModel.getUserRole());
        return userRepository.save(user);
    }
	
}
