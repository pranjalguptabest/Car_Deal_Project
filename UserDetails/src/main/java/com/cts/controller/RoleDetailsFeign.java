package com.cts.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.model.RoleModelProxy;

@FeignClient(name="RoleDetails")
public interface RoleDetailsFeign {
	
	@GetMapping("/getRoleDetails")
	public List<RoleModelProxy> getRoleDetails();

}
