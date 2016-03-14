package com.vpath.appcenter.repository;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vpath.appcenter.AppCenterApplication;
import com.vpath.appcenter.domain.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppCenterApplication.class)
@ActiveProfiles("test")
@DirtiesContext
public class ApplicationRepositoryDeleteTests {
	@Autowired
	private ApplicationRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(AppCenterApplication.class);
	
	@BeforeClass
	public static void before(){
		log.debug("Im in before class method");
	}
	
	@AfterClass
	public static void after(){
		log.debug("Im in after class method");
	}

	@Test
	public void deleteTest(){
		Application app = new Application();
		String name = "Test";
		app.setName(name);
		log.debug("after setting name variable");
		String description = "Simple test app";
		app.setDescription(description);
		log.debug("after setting description variable");
		repository.save(app);
		Application resultApp = this.repository.findOne(app.getId());
		log.debug("The id is " + resultApp.getId().toString());
		assertEquals(name, resultApp.getName());
		assertEquals(description, resultApp.getDescription());
	}
}
