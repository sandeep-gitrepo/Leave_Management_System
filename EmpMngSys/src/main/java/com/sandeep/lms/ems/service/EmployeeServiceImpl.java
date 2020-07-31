/**
 * 
 */
package com.sandeep.lms.ems.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;
import com.sandeep.lms.ems.dao.EmployeeDAO;
import com.sandeep.lms.dto.EmployeeDTO;

/**
 * @author sandeep.a.kumar
 *
 */

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	public void addEmployee(EmployeeDTO employeeDTO) throws MongoException {
		LOGGER.info("EmployeeServiceImpl: addEmployee() method called ===============");
		
		try {
			employeeDAO.addEmployee(employeeDTO);
			LOGGER.info("Employee record inserted successfully.");
		}
		catch (MongoException e) {
			LOGGER.error("MongoException: Error occured while Inserting record.");
			throw new MongoException(e.getMessage());
		}
		catch (Exception e2) {
			LOGGER.error("Exception: Error occured while Inserting record.");
			throw new MongoException(e2.getMessage());
		}
		
	}

	public void editEmployee(EmployeeDTO employeeDTO) throws MongoException {
		LOGGER.info("EmployeeServiceImpl: editEmployee() method called ===============");
		
		try {
			employeeDAO.editEmployee(employeeDTO);
			LOGGER.info("Employee record updated successfully.");
		}
		catch (MongoException e) {
			LOGGER.error("MongoException: Error occured while updating record.");
			throw new MongoException(e.getMessage());
		}
		catch (Exception e2) {
			LOGGER.error("Exception: Error occured while updating record.");
			throw new MongoException(e2.getMessage());
		}
		
	}

	public EmployeeDTO getEmployeeByID(Integer empId) throws MongoException {
		LOGGER.info("EmployeeServiceImpl: getEmployeeByID() method called ===============");
		
		try {
			if(empId == null || empId.intValue() == 0) {
				LOGGER.error("Error Occured: Employee ID not be null or Zero.");
				throw new MongoException("Error Occured: Employee ID not be null or Zero.");
			}
			
			EmployeeDTO empDTO = employeeDAO.getEmployeeByID(empId);
			LOGGER.info("Employee record found successfully.");
			return empDTO;
		}
		catch (MongoException e) {
			LOGGER.error("MongoException: Error occured while finding Employee record.");
			throw new MongoException(e.getMessage());
		}
		catch (Exception e2) {
			LOGGER.error("Exception: Error occured while finding Employee record.");
			throw new MongoException(e2.getMessage());
		}

	}

	public void deleteEmployee(Integer empId) throws MongoException {
		LOGGER.info("EmployeeServiceImpl: deleteEmployee() method called ===============");
		
		try {
			if(empId == null || empId.intValue() == 0) {
				LOGGER.error("Error Occured: Employee ID not be null or Zero.");
				throw new MongoException("Error Occured: Employee ID not be null or Zero.");
			}
			
			
			
			employeeDAO.deleteEmployee(empId);
			LOGGER.info("Employee record deleted successfully.");
		}
		catch (MongoException e) {
			LOGGER.error("MongoException: Error occured while deleting Employee record.");
			throw new MongoException(e.getMessage());
		}
		catch (Exception e2) {
			LOGGER.error("Exception: Error occured while deleting Employee record.");
			throw new MongoException(e2.getMessage());
		}
		
	}

	public List<EmployeeDTO> getAllEmployees() throws MongoException {
		LOGGER.info("EmployeeServiceImpl: getAllEmployees() method called ===============");
		
		try {
			List<EmployeeDTO> empDTOList = employeeDAO.getAllEmployees();
			LOGGER.info("All Employees record found successfully.");
			
			return empDTOList;
		}
		catch (MongoException e) {
			LOGGER.error("MongoException: Error occured while finding All Employees record.");
			throw new MongoException(e.getMessage());
		}
		catch (Exception e2) {
			LOGGER.error("Exception: Error occured while finding All Employees record.");
			throw new MongoException(e2.getMessage());
		}
		
	}

	
}