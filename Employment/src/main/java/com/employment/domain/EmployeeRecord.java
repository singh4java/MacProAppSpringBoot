package com.employment.domain;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EmployeeRecord")
public class EmployeeRecord {

	
	private int employmentId;
	
	private String employeeName;
	
	private String employeeEducation;
	
	private LocalDate doj;
	
	public EmployeeRecord() {
		super();
	}
	public EmployeeRecord(int employmentId, String employeeName, String employeeEducation, LocalDate doj) {
		super();
		this.employmentId = employmentId;
		this.employeeName = employeeName;
		this.employeeEducation = employeeEducation;
		this.doj = doj;
	}
	@XmlElement
	public int getEmploymentId() {
		return employmentId;
	}
	public void setEmploymentId(int employmentId) {
		this.employmentId = employmentId;
	}
	@XmlElement
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@XmlElement
	public String getEmployeeEducation() {
		return employeeEducation;
	}
	public void setEmployeeEducation(String employeeEducation) {
		this.employeeEducation = employeeEducation;
	}
	@XmlElement
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	
	
	
}
