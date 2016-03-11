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
public class ApplicationServiceImplSaveTest {
	@Autowired
	ApplicationService service;
	
	@Autowired
	ApplicationRepository repository;
	
	public ApplicationServiceImplSaveTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void saveTest(){
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName("Test");
		dtoObject.setDescription("Test application");
		this.service.saveApplication(dtoObject);
		Application resultApp = this.repository.findOne(7L);
		assertEquals(dtoObject.getName(), resultApp.getName());
		assertEquals(dtoObject.getDescription(), resultApp.getDescription());
	}
	
}
