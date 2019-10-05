package com.cognizant.springlearn;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bean.Employee;

@SpringBootApplication
@ComponentScan({"com.cognizant.controller","com.cognizant.springlearn"})
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		/*displayDate();*/
		/*displayCountry();*/
		/*displayCountries();*/
//		displayEmployee();
	}

	/*public static void displayDate() throws ParseException{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		 Date date =format.parse("31/12/2018"); 
		 LOGGER.debug(date.toString());	
		 LOGGER.info("END");
		 
	}*/
	
	/*public static void displayCountry(){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}*/

	/*public static void displayCountries(){
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList countryList = (ArrayList) context.getBean("countryList",ArrayList.class);
		
		for(Object var: countryList.toArray()){
			LOGGER.debug("Country :  {}",var.toString());
		}
		
		
	}

*/
	public static void displayEmployee(){
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee_details = (Employee) context.getBean("employee_details",Employee.class);
		LOGGER.debug("Employee : {}",employee_details.toString());
		
	}
	
	
}


