package com.vpath.appcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vpath.appcenter.dto.ApplicationDTO;
import com.vpath.appcenter.service.ApplicationService;

@RestController
public class ApplicationRestController {
	@Autowired
	ApplicationService service;
	
	public ApplicationRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/get")
	public ApplicationDTO getApplication(){
		return this.service.getApplication(new ApplicationDTO()); 
	}
	
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public ApplicationDTO getApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=false) String description){
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		return this.service.getApplication(dtoObject); 
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public void createApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=true) String description){
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		this.service.saveApplication(dtoObject);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void deleteApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=false) String description){
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		this.service.deleteApplication(dtoObject);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void deleteApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="updatedname", required=false) String updatedName,
			@RequestParam(value="updateddescription", required=false) String updatedDescription){
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		ApplicationDTO updatedDtoObject = new ApplicationDTO();
		updatedDtoObject.setName(updatedName);
		updatedDtoObject.setDescription(updatedDescription);
		
		this.service.updateApplication(dtoObject, updatedDtoObject);
	}
	
}
