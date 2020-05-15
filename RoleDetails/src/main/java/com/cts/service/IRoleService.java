package com.cts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.LoginModel;
import com.cts.model.RoleModel;

@Service
public interface IRoleService {
	
	public List<RoleModel> getAllRoleDetails();
	public void saveRoleDetails(RoleModel roleModel);
	public String matchRole(LoginModel loginModel);

}
