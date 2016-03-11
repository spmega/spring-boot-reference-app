package com.vpath.appcenter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Application {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	
	@NotNull
	@Column(unique=true)
	private String name;
	
	@NotNull
	private String description;
	
	public Application() {
		// TODO Auto-generated constructor stub
	}
	
	public Application(String name, String description) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
