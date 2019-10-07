package com.cognizant.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Skill {

	private static final Logger LOGGER = LoggerFactory.getLogger(Skill.class);
	@NotNull
	@Min(value=0)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min=1,max=30,message="Name should be 1 character")
	private String name;
	
	public Skill() {
		super();
		LOGGER.debug("Inside Skill Constructor");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
