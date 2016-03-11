package com.vpath.appcenter.controller;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.vpath.appcenter.AppCenterApplication;
import com.vpath.appcenter.dto.ApplicationDTO;
import com.vpath.appcenter.service.ApplicationService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppCenterApplication.class)
@WebIntegrationTest
@IntegrationTest("server.port:8000")
public class ApplicationRestControllerGetApplicationIT {
	@Autowired
	ApplicationService service;
	
	@Value("${local.server.port}")
	private static int serverPort;
	
	public ApplicationRestControllerGetApplicationIT() {
		// TODO Auto-generated constructor stub
	}

	@Before
	public void before(){
	    RestAssured.port = 8000;
	}
	
	@Test
	public void getApplicationTests(){
		  RestAssured.when()
		    .get("/get")
		  .then()
		    .statusCode(HttpStatus.SC_OK)
		    .contentType(ContentType.JSON);		    
	}
	
	@Test
	public void getApplicationTests2(){
		  expect()
		  	.statusCode(HttpStatus.SC_OK)
		  	.body("name", equalTo("Susan"))
		  	.body("description", equalTo("Susana"))
		  .when()
		  	.get("/get");
	}
	
	@Test
	public void createApplicationTests(){
		String name = "TestApp";
		String description = "Integration Testing, very exciting";
		
		with().parameters("name", name, "description", description)  
		.expect()
		  	.statusCode(HttpStatus.SC_OK)
		  .when()
		  	.post("/create");
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		ApplicationDTO resultDtoObject = this.service.getApplication(dtoObject);
		assertEquals(name, resultDtoObject.getName());
		assertEquals(description, resultDtoObject.getDescription());
		
	}
	
	@Test
	public void deleteApplicationTests(){
		with().parameters("name", "TestApp", "description", "Integration Testing, very exciting")  
		.expect()
		  	.statusCode(HttpStatus.SC_OK)
		  .when()
		  .post("/delete");
	}
}
