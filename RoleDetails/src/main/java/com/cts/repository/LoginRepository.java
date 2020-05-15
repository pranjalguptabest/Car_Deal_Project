package com.cts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.LoginModel;

@Repository
public interface LoginRepository extends CrudRepository<LoginModel,Long>{

}
