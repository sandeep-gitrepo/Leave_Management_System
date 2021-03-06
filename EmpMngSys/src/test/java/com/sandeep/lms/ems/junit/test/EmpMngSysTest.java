/**
 * 
 */
package com.sandeep.lms.ems.junit.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sandeep.lms.dto.EmployeeDTO;
import com.sandeep.lms.ems.service.EmployeeService;

/**
 * @author sandeep.a.kumar
 *
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class EmpMngSysTest {

	@Autowired
	EmployeeService employeeService;

	@Test
	public void addEmployee() {
		System.out.println("EmpMngSysTest ===> addEmployee() method called =====");

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(22);
		employeeDTO.setEmpName("Prerena Singh");
		employeeDTO.setCtc(11f);
		employeeDTO.setDepartment("test");
		employeeDTO.setDesignation("des");
		employeeService.addEmployee(employeeDTO);
	}

	@Test
	public void editEmployee() {
		System.out.println("EmpMngSysTest ===> editEmployee() method called =====");

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(5);
		employeeDTO.setCtc(11f);
		employeeDTO.setDepartment("S/w Development");
		employeeDTO.setDesignation("S/w Eng.");
		employeeService.editEmployee(employeeDTO);
	}

	@Test
	public void getEmployeeByID() {
		System.out.println("EmpMngSysTest ===> getEmployeeByID() method called =====");

		EmployeeDTO employeeDTO = employeeService.getEmployeeByID(1);

		if (employeeDTO != null) {
			System.out.println("Emp ID : " + employeeDTO.getEmpId());
			System.out.println("Emp Name : " + employeeDTO.getEmpName());
			System.out.println("Department : " + employeeDTO.getDepartment());
			System.out.println("Designation : " + employeeDTO.getDesignation());
			System.out.println("CTC : " + employeeDTO.getCtc());

		}
	}

	@Test
	public void deleteEmployee() {
		System.out.println("EmpMngSysTest ===> getEmployeeByID() method called =====");

		try {
			employeeService.deleteEmployee(19);
			System.out.println("Employee record deleted successfully.");
		} catch (Exception e) {
			System.out.println("Error occured while deleting employee record.");
		}

	}

	@Test
	public void getAllEmployees() {
		System.out.println("EmpMngSysTest ===> getAllEmployees() method called =====");
		
		List<EmployeeDTO> list = employeeService.getAllEmployees();

		if (list != null) {
			for (EmployeeDTO dto : list) {
				System.out.println(dto.getEmpId() + " - " + dto.getEmpName() + " - " + dto.getDesignation() + " - " + dto.getDepartment() + " - " + dto.getCtc());
			}
		}
	}

}
