package com.vpath.appcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	}
	
	@RequestMapping("/get")
	public ResponseEntity<ApplicationDTO> getApplication(){
		ResponseEntity<ApplicationDTO> response  = null;
		ApplicationDTO applicationDTO =  new ApplicationDTO();
		response  =new ResponseEntity<ApplicationDTO>(applicationDTO,HttpStatus.OK);
		return response; 
	}
	
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public ResponseEntity<ApplicationDTO> getApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=false) String description){
		
		ApplicationDTO dtoObject = null;
		ResponseEntity<ApplicationDTO> response  = null;

		dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		this.service.getApplication(dtoObject);
		response  =new ResponseEntity<ApplicationDTO>(dtoObject,HttpStatus.OK);
		return response; 
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<ApplicationDTO> createApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=true) String description){
		
		ResponseEntity<ApplicationDTO> response  = null;
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		this.service.saveApplication(dtoObject);
		response  =new ResponseEntity<ApplicationDTO>(dtoObject,HttpStatus.OK);
		return response; 
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResponseEntity<?> deleteApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=false) String description){
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		this.service.deleteApplication(dtoObject);
		return new ResponseEntity<>("Application deleted", HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<?> deleteApplication(@RequestParam(value="name", required=true) String name,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="updatedname", required=false) String updatedName,
			@RequestParam(value="updateddescription", required=false) String updatedDescription){
		
		ApplicationDTO dtoObject = new ApplicationDTO();
		dtoObject.setName(name);
		dtoObject.setDescription(description);
		
		ApplicationDTO updatedDtoObject = new ApplicationDTO();
		updatedDtoObject.setName(updatedName);
		updatedDtoObject.setDescription(updatedDescription);
		
		this.service.deleteApplication(updatedDtoObject);
		
		return new ResponseEntity<>("Application deleted", HttpStatus.OK);
	}
	
}
