package com.vpath.appcenter.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vpath.appcenter.AppCenterApplication;
import com.vpath.appcenter.domain.Application;
import com.vpath.appcenter.dto.ApplicationDTO;
import com.vpath.appcenter.repository.ApplicationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppCenterApplication.class)
@ActiveProfiles("test")
public class ApplicationServiceImplGetTest {
	@Autowired
	ApplicationService service;
	
	@Autowired
	ApplicationRepository repository;
	
	public ApplicationServiceImplGetTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void getTest(){
		ApplicationDTO dtoObject = new ApplicationDTO();
		String name = "Susan";
		dtoObject.setName(name);
		
		String description = null;
		dtoObject.setDescription(description);
		
		ApplicationDTO resultDtoObject = this.service.getApplication(dtoObject);
		
		assertEquals(dtoObject.getName(), resultDtoObject.getName());
		assertNotEquals(dtoObject.getDescription(), resultDtoObject.getDescription());
	}
	
}
