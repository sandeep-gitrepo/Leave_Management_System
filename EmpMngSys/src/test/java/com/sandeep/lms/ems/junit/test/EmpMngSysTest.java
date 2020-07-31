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
		EmployeeDTO employeeDTO = null;
		System.out.println("hi");
	}

	@Test
	public void editEmployee() {
		System.out.println("hi");
	}

	@Test
	public void getEmployeeByID() {
		System.out.println("hi");
	}

	@Test
	public void deleteEmployee() {
		System.out.println("hi");
	}

	@Test
	public void getAllEmployees() {
		List<EmployeeDTO> list = employeeService.getAllEmployees();

		if (list != null) {
			for (EmployeeDTO dto : list) {
				System.out.println(dto.getEmpId() + " - " + dto.getEmpName() + " - " + dto.getDesignation());
			}
		}
	}

}
