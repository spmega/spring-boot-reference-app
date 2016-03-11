package com.vpath.appcenter.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpath.appcenter.domain.Application;
import com.vpath.appcenter.dto.ApplicationDTO;
import com.vpath.appcenter.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	ApplicationRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);
	
	public ApplicationServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ApplicationDTO saveApplication(ApplicationDTO dtoObject) {
		// TODO Auto-generated method stub
		Application app = new Application();
		app.setName(dtoObject.getName());
		app.setDescription(dtoObject.getDescription());
		this.repository.save(app);
		return dtoObject;
	}

	@Override
	public ApplicationDTO deleteApplication(ApplicationDTO dtoObject) {
		// TODO Auto-generated method stub
		Application app = this.repository.findByNameAndDescription(dtoObject.getName(), dtoObject.getDescription());
		this.repository.delete(app);
		return dtoObject;
	}

	@Override
	public ApplicationDTO updateApplication(ApplicationDTO dtoObject, ApplicationDTO updatedDtoObject) {
		// TODO Auto-generated method stub
		Application app = this.repository.findByNameAndDescription(dtoObject.getName(), dtoObject.getDescription());
		String updatedName = updatedDtoObject.getName();
		String updatedDesc = updatedDtoObject.getDescription();
		
		if(updatedName != null && updatedDesc != null){
			app.setName(updatedDtoObject.getName());
			app.setDescription(updatedDtoObject.getDescription());
		} else if(updatedName != null && updatedDesc == null){
			app.setName(updatedDtoObject.getName());
		}else if(updatedName == null && updatedDesc != null){
			app.setDescription(updatedDtoObject.getDescription());
		}
		
		this.repository.save(app);
		return dtoObject;
	}

	@Override
	public ApplicationDTO getApplication(ApplicationDTO dtoObject) {
		// TODO Auto-generated method stub
		ApplicationDTO resultDTO = new ApplicationDTO();
		Application app = null;
		String name = dtoObject.getName();
		String description = dtoObject.getDescription();
		
		if(name != null && description != null)
			app = this.repository.findByNameAndDescription(name, description);
		else if(name != null)
			app = this.repository.findByName(name);
		else if(description != null)
			app = this.repository.findByDescription(description);
		else
			app = this.repository.findOne(1L);
		
		resultDTO.setName(app.getName());
		resultDTO.setDescription(app.getDescription());
		
		return resultDTO;
	}

}
