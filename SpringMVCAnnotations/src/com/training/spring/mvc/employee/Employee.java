package com.training.spring.mvc.employee;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.training.spring.mvc.common.annotations.NameValidator;

public class Employee {

	@NotNull
	private String empID;

	@NameValidator(startsWith="N")
	@Size(min = 3, max = 20)
	private String empName;

	@Past
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	private Date dateOfJoining;
	private List<String> languages;
	private String monthsOfExperience;

	public Employee(String empID, String empName, Date dateOfBirth,
			List<String> languages, Date dateOfJoining) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.dateOfBirth = dateOfBirth;
		this.languages = languages;
		this.dateOfJoining = dateOfJoining;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName
				+ ", dateOfBirth=" + dateOfBirth + ", languages=" + languages
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMonthsOfExperience() {
		return monthsOfExperience;
	}

	public void setMonthsOfExperience(String monthsOfExperience) {
		this.monthsOfExperience = monthsOfExperience;
	}

}
