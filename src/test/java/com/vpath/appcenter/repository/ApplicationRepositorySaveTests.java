package com.vpath.appcenter.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vpath.appcenter.AppCenterApplication;
import com.vpath.appcenter.domain.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppCenterApplication.class)
@ActiveProfiles("test")
public class ApplicationRepositorySaveTests {
	@Autowired
	private ApplicationRepository repository;
	
	public ApplicationRepositorySaveTests() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void saveTest(){
		Application app = new Application();
		String name = "Test";
		app.setName(name);
		
		String description = "Simple test app";
		app.setDescription(description);
		
		repository.save(app);
		Application resultApp = this.repository.findOne(app.getId());
		
		assertEquals(name, resultApp.getName());
		assertEquals(description, resultApp.getDescription());
	}

}
