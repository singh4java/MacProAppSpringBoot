package com.employment.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employment.domain.EmployeeRecord;

@RestController
@RequestMapping("Employee")
public class EmploymentController {

	private static List<EmployeeRecord> emplist = new ArrayList<EmployeeRecord>();

	static{
		for(int i=1;i<10;i++){
		emplist.add(new EmployeeRecord(i, "employeeName"+i, "employeeEducation"+i,  LocalDate.now()));
	}
	}
	
	@RequestMapping(value="/Employees",method=RequestMethod.GET,produces="application/xml") 
	List<EmployeeRecord> allEmployee(){
		return emplist;
	}
		
	

}
