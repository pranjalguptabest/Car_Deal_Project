package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.model.UserModel;

public interface IUserService {

	
	public List<UserModel> getAllUserDetails();
	public void saveUserDetails(UserModel userModel);
	public Optional<UserModel> getById(Long id);
	public void deleteUserDetails(Long personId);
	public boolean updateUserDetails(UserModel person);
}
