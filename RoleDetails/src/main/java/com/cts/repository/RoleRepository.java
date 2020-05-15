package com.cts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.RoleModel;

@Repository
public interface RoleRepository extends CrudRepository<RoleModel,Long>{
	
//	@Query(value="select * from role_details where user_id=loginModel.userId and password=loginModel.password;",nativeQuery = true)
//	List<RoleModel> matchRole(LoginModel loginModel);

	

}
