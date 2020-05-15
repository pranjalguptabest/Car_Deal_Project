package com.cts;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.model.RoleModel;
import com.cts.repository.RoleRepository;
import com.cts.service.IRoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDetailsApplicationTests {
	
	@MockBean
	RoleRepository roleRepository;
	
	@Autowired
	IRoleService roleService;
	
	@Test
	public void fetchRoleList() {
		when(roleRepository.findAll()).thenReturn(Stream.of(new RoleModel(36l,42l,"user","pass")
				,new RoleModel(37l,52l,"admin","action")).collect(Collectors.toList()));
		
		assertEquals(2,roleService.getAllRoleDetails().size());
	}
	
	@Test
	public void saveRoleDetail() throws Exception{
		
		RoleModel roleModel = new RoleModel(30l,45l,"admin","kuchBhi");
		when(roleRepository.save(roleModel)).thenReturn(roleModel);
	}
	
	
}
