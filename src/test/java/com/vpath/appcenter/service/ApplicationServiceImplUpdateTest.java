package com.vpath.appcenter.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ApplicationServiceImplUpdateTest {
	@Autowired
	ApplicationService service;
	
	@Autowired
	ApplicationRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationServiceImplDeleteTest.class);
	
	public ApplicationServiceImplUpdateTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Before
	public void before(){
		log.debug("This is the beginning of the tests");
	}
	
	@After
	public void after(){
		log.debug("This is the end of the tests");
	}
	
	@BeforeClass
	public static void beforeClass(){
		log.debug("This is the BEGINNING of a TEST");
	}
	
	@AfterClass
	public static void afterClass(){
		log.debug("This is the END of a TEST");
	}
	
	@Test
	public void updateTest(){
		String name = "Test";
		String description = "Test application";
		
		String updatedName = "Test";
		String updatedDescription = "Test application updated";
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		ApplicationDTO updatedDtoObject = new ApplicationDTO();
		
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		updatedDtoObject.setName(updatedName);
		updatedDtoObject.setDescription(updatedDescription);
		
		this.service.saveApplication(dtoObject);
		Application savedApp = this.repository.findByNameAndDescription(name, description);
		
		this.service.updateApplication(dtoObject, updatedDtoObject);
		Application updatedApp = this.repository.findByNameAndDescription(updatedName, updatedDescription);
		
		assertNotNull(updatedApp);
		assertNotNull(savedApp);
		
		assertNotEquals(savedApp.getDescription(), updatedApp.getDescription());
		
		assertEquals(savedApp.getName(), updatedApp.getName());
		assertEquals(savedApp.getClass(), updatedApp.getClass());
		assertEquals(savedApp.getId(), updatedApp.getId());
	}
	
}
