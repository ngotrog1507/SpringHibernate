package com.viettel.erp.service;
 
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloWorldService {

	private static final Logger logger = Logger.getLogger(HelloWorldService.class);

	public String getDesc() {

		logger.debug("getDesc() is executed!");

		return "Gradle + Spring MVC Hello World Example";

	}

	public String getTitle(String name) {

		logger.debug("getTitle() is executed! $name : {}" + name);

		if(StringUtils.isEmpty(name)){
			return "Hello World";
		}else{
			return "Hello " + name;
		}
		
	}

}