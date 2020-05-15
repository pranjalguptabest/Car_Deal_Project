package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.UserModel;
import com.cts.service.IUserService;

@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService iUserService;
	
	@GetMapping("/getUserDetails")
	public List<UserModel> getUserDetails(){
		logger.info("Fetching All user Details...");
		logger.error("Unable to Get Users...");
		return iUserService.getAllUserDetails();
	}
	
	@PostMapping("/setUserDetails")
	public void insertUserDetails(@RequestBody UserModel userModel) {
		iUserService.saveUserDetails(userModel);
		logger.info("Data Saved Successfully");
		logger.error("Unable to Save Data...");
	}
	
	@RequestMapping(value = "/deleteUserDetails/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteStudent(@PathVariable Long id) {
		iUserService.deleteUserDetails(id);
		return HttpStatus.NO_CONTENT;
	}
	
	@RequestMapping(value = "/updateUserDetails", method = RequestMethod.PUT)
	public HttpStatus updateStudent(@RequestBody UserModel userModel) {
		return iUserService.updateUserDetails(userModel)  ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
	@RequestMapping(value = "/findUserDetails/{id}", method = RequestMethod.GET)
	public Optional<UserModel> getStudent(@PathVariable Long id) {
		return iUserService.getById(id);
	}

}
