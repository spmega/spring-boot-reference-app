package com.vpath.appcenter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vpath.appcenter.domain.Application;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
	Application findByNameAndDescription(String name, String description);
	List<Application> findAll();
	Application findByName(String name);
	Application findByDescription(String description);
}
