package com.vpath.appcenter.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vpath.appcenter.AppCenterApplication;
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
		String name = "Save Test";
		String description = "Save Test application";
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		this.service.saveApplication(dtoObject);
		
		ApplicationDTO resultDtoObject = this.service.getApplication(dtoObject);
		
		assertEquals(name, resultDtoObject.getName());
		assertEquals(description, resultDtoObject.getDescription());
	}
	
}
