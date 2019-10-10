package com.cognizant.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.service.CountryService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class); 
	
	@GetMapping("/country")
	public Country getCountry(){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}
	
	
	@GetMapping("/countries")
	public ArrayList getAllCountries(){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countryList = (ArrayList) context.getBean("countryList",ArrayList.class);
		return countryList;
	}
	
	@GetMapping("/countries/{code}")
	public ResponseEntity<?> getCountry(@PathVariable("code")String code) throws CountryNotFoundException{
		Country country = CountryService.getCountry(code);
		if(null==country){
			return new ResponseEntity<Object>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(country,HttpStatus.OK);
	}
	
	@PostMapping("/countries")
	public ArrayList getCountry(@RequestBody Country country){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countryList = (ArrayList) context.getBean("countryList",ArrayList.class);
		countryList.add(country);
		return countryList;
	}
	
	@DeleteMapping("/countries/{code}")
	public ResponseEntity<?> removeCountry(@PathVariable("code")String code) throws CountryNotFoundException{
		Country country = CountryService.removeCountry(code);
		if(null==country){
			return new ResponseEntity<Object>(null,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(country,HttpStatus.OK);
	}
	
	
	/*@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country){
		LOGGER.info("START");
		LOGGER.info(country.toString());
		return country;
	}*/
}
