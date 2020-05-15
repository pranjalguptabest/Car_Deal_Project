package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.LoginModel;
import com.cts.model.RoleModel;
import com.cts.service.IRoleService;

@RestController
public class RoleController {
	
	@Autowired
	IRoleService iRoleService;
	
	@GetMapping("/getRoleDetails")
	public List<RoleModel> getRoleDetails(){
		return iRoleService.getAllRoleDetails();
	}
	
	@PostMapping("/setRoleDetails")
	public void insertUserDetails(@RequestBody RoleModel roleModel) {
		iRoleService.saveRoleDetails(roleModel);
	}

//	@RequestMapping(value = "/matchRoleDetails/{id}", method = RequestMethod.GET)
//	public Optional<LoginModel> matchUserDetails(@PathVariable Long id) {
//		return iRoleService.getById(id);
//	}
	
	@PostMapping("/matchRoleDetails")
	public String matchRoleDetails(@RequestBody LoginModel loginModel) {
				return iRoleService.matchRole(loginModel);
	}
	
//	@RequestMapping(value = "/matchDetails/{id}", method = RequestMethod.GET)
//	public Optional<RoleModel> matchDetails(@PathVariable Long id) {
//		return iRoleService.getById(id);
//	}
	
//	@PostMapping("/matchPass")
//	public void matchPass()
}
