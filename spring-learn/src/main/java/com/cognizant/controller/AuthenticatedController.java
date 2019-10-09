package com.cognizant.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public class AuthenticatedController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("AuthenticatedController.class"); 
	Map<String,String> map = new HashMap<String,String>();
	
	map.put("token"," ");
	
	@GetMapping("/authenticate")
	public Map<String,String> authenticate(@RequestHeader("Authorization") String authHeader){
		LOGGER.info("START");
		LOGGER.info("END");
		
		
		
	}
}
