package com.vpath.appcenter.service;

import com.vpath.appcenter.domain.Application;
import com.vpath.appcenter.dto.ApplicationDTO;

public interface ApplicationService {
	public ApplicationDTO saveApplication(ApplicationDTO dtoObject);
	public ApplicationDTO deleteApplication(ApplicationDTO dtoObject);
	public ApplicationDTO updateApplication(ApplicationDTO dtoObject, ApplicationDTO updatedDtoObject);
	public ApplicationDTO getApplication(ApplicationDTO dtoObject);
}
