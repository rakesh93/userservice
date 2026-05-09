package com.ilearn.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ilearn.userservice.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	List<UserModel> findByUserRole(String userRole);
	
}
