package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.model.LoginModel;
import com.cts.model.RoleModel;
import com.cts.repository.LoginRepository;
import com.cts.repository.RoleRepository;

@Service
@Transactional
public class RoleService implements IRoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	public List<RoleModel> getAllRoleDetails(){
		return (List<RoleModel>) roleRepository.findAll();
	}
	
	public void saveRoleDetails(RoleModel roleModel) {
		roleRepository.save(roleModel);
	}
	public String matchRole(LoginModel loginModel){
		LoginModel role;
		Optional<LoginModel> proxy = loginRepository.findById(loginModel.getUserId());
	     if(proxy.isPresent()) {
		role = proxy.get();
		if(role.getPassword().equals(loginModel.getPassword())){
			if(role.getUserType().equals("user")) {
				return "welcome user";
			}else {
				return "welcome admin";
			}
			
		}else {
			return "Password Didn't Match";
		}
	}else {
		return "UserId is Not Present";
	}
//	     if(role.getPassword()==loginModel.getPassword()){
////	    	 if(role.getUserType()=="user") {
////	    		 return "User";
////	    	 }else {
////	    		 return "Admin";
////	    	 }
//	    	 return "welcome";
//	     }else {
//	    	 return "Password Didn't Match";
//	     }
	

}
}
