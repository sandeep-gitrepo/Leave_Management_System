/**
 * 
 */
package com.sandeep.lms.ems.dao;

import java.util.List;

import com.sandeep.lms.dto.EmployeeDTO;

/**
 * @author sandeep.a.kumar
 *
 */
public interface EmployeeDAO {

	void addEmployee(EmployeeDTO employeeDTO);

	void editEmployee(EmployeeDTO employeeDTO);

	EmployeeDTO getEmployeeByID(Integer empId);

	void deleteEmployee(Integer empId);

	List<EmployeeDTO> getAllEmployees();

}
