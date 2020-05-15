package com.cts.repository;

import org.springframework.data.repository.CrudRepository;

import com.cts.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel,Long>{

}
