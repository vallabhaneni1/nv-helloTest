/*
 * Copyright 2012-2020 the original author or authors.
 *
 * Copyright IBM Corp. 2020 All Rights Reserved   
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibm.cicsdev.springboot.jpa;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller used to direct incoming requests to the correct business
 * service.
 * 
 * @RestController: build a Restful controller
 * @Autowired: drive Dependency Injection
 * @GetMapping: Annotation for mapping HTTP GET requests onto specific handler
 *              methods.
 */

@RestController
public class EmployeeRestController {

	/**
	 * @return message containing data and time - simple test of the application
	 */
	@GetMapping("/")
	@ResponseBody
	public String Index() {
		Date myDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss.SSSSSS");
		String myDateString = sdf.format(myDate);

		return "<h1>Spring Boot JPA Employee REST sample. Date/Time: " + myDateString + "</h1>" + "<h3>Usage:</h3>"
				+ "<b>/allEmployees</b> - return a list of employees<br>"
				+ "<b>/listEmployee/{empno}</b> - list employee records for the employee number provided <br>"
				+ "<br> --- Update operations --- <br>"
				+ "<b>/addEmployee/{firstName}/{lastName}</b> - add an employee <br>"
				+ "<b>/deleteEmployee/{empNo}</b> - delete an employee <br>"
				+ "<b>/updateEmployee/{empNo}/{newSalary}</b> - update employee salary <br>";
	}

}
