package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.model.UserModel;
import com.cts.repository.UserRepository;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<UserModel> getAllUserDetails(){
		return (List<UserModel>) userRepository.findAll();
	}
	
	public void saveUserDetails(UserModel userModel) {
		userRepository.save(userModel);
	}
	
	public Optional<UserModel> getById(Long id) {
		return userRepository.findById(id);
	}
	
	public void deleteUserDetails(Long personId) {
		userRepository.deleteById(personId);
	}
	
	public boolean updateUserDetails(UserModel person) {
		return userRepository.save(person) != null;
	}
	

}
