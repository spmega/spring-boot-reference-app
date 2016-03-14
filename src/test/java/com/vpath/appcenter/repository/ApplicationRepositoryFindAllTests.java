package com.vpath.appcenter.repository;

import static org.junit.Assert.*;

import java.util.List;

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
public class ApplicationRepositoryFindAllTests {
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
	public void findAllTest(){
		List<Application> resultApps = this.repository.findAll();
		//assertEquals(resultApps.size(), 4);
		assertEquals(6,resultApps.size());
		//assertNotEquals(resultApps.size(), 9);
	}
}
