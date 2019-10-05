package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;

public class CountryService {

	public static Country getCountry(String code)throws CountryNotFoundException{
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	List<Country> countries = (ArrayList<Country>) context.getBean("countryList",ArrayList.class);
	Country country = null;
	
	for(int i=0;i<countries.size();i++){
		if(countries.get(i).getCode().equalsIgnoreCase(code)){
			country=countries.get(i);
		}
	}
	if(country==null){
		throw new CountryNotFoundException();
	}
	else{
		return country;
	}
	
	}
	}
