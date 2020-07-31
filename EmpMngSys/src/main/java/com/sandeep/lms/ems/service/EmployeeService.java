package com.sandeep.lms.ems.service;

import java.util.List;

import com.mongodb.MongoException;
import com.sandeep.lms.dto.EmployeeDTO;

public interface EmployeeService {

	void addEmployee(EmployeeDTO employeeDTO) throws MongoException;
	
	void editEmployee(EmployeeDTO employeeDTO) throws MongoException;
	
	EmployeeDTO getEmployeeByID(Integer empId) throws MongoException;
	
	void deleteEmployee(Integer empId) throws MongoException;

	List<EmployeeDTO> getAllEmployees() throws MongoException;

}
