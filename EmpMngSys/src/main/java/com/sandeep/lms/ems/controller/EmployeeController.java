/**
 * 
 */
package com.sandeep.lms.ems.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sandeep.lms.dto.EmployeeDTO;
import com.sandeep.lms.ems.service.EmployeeService;

/**
 * @author sandeep.a.kumar
 *
 */

@Controller
public class EmployeeController {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	/*
	 * @ResponseBody
	 * @RequestMapping("/addEmp") public String showform(Model m){
	 * m.addAttribute("command", new EmployeeDTO()); return "Hey Guys what's up...!!!"; }
	 * 
	 * Note: Using @ResponseBody means add the returns in the Http Response and print the data directly in the web browser.
	 * It will not redirect to any page. 
	 */
	
	@RequestMapping("/addemp")    
    public String showform(Model m){
		LOGGER.info("showform() method called ============");
		
        m.addAttribute("command", new EmployeeDTO());  
        return "addEmployeeForm";   
    } 
	
	@RequestMapping(value = "/addEmpAction", method = RequestMethod.POST)
	public String addEmployee(Model m, EmployeeDTO employeeDTO) {
		LOGGER.info("addEmployee() method called ============");
		LOGGER.debug("addEmployee() method called ============");
		
		employeeService.addEmployee(employeeDTO);
		getAllEmployees(m);
		return "viewEmployeeForm";
	}
	
	@RequestMapping(value = "/editEmpForm/{empId}", method = RequestMethod.GET)
	public String editEmployeeForm(@PathVariable Integer empId, Model model) {
		LOGGER.info("editEmployeeForm() method called ============");
		
		EmployeeDTO empDTO = employeeService.getEmployeeByID(empId);
		model.addAttribute("command", empDTO);
		
		return "editEmployeeForm";
	}
	
	@RequestMapping(value = "/editEmpAction", method = RequestMethod.POST)
	public String editEmployee(Model model, EmployeeDTO empDTO) {
		LOGGER.info("editEmployee() method called ============");
		System.out.println("=====================");
		employeeService.editEmployee(empDTO);
		getAllEmployees(model);
		return "viewEmployeeForm";
	}
	
	@RequestMapping(value = "/deleteEmpForm/{empId}", method = RequestMethod.GET)
	public String deleteEmployeeForm(@PathVariable Integer empId, Model model) {
		LOGGER.info("deleteEmployeeForm() method called ============");
		
		EmployeeDTO empDTO = employeeService.getEmployeeByID(empId);
		model.addAttribute("command", empDTO);
		
		return "deleteEmployeeForm";
	}
	
	@RequestMapping(value = "/deleteEmpAction/{empId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("empId") Integer empId, Model m) {
		LOGGER.info("deleteEmployee() method called ============");
		
		employeeService.deleteEmployee(empId);
		getAllEmployees(m);
		
		return "viewEmployeeForm";
	}
	
	@RequestMapping(value = "/findEmpAction", method = RequestMethod.GET)
	public String findEmployee(@PathVariable("empId") Integer empId) {
		LOGGER.info("findEmployee() method called ============");
		
		employeeService.getEmployeeByID(empId);
		return "viewEmployeeForm";
	}
	
	@RequestMapping(value = "/getAllEmpAction", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		LOGGER.info("getAllEmployees() method called ============");
		LOGGER.debug("getAllEmployees() method called ============");
		
		List<EmployeeDTO> empList = employeeService.getAllEmployees();
		model.addAttribute("empList", empList);
		return "viewEmployeeForm";
	}
	
}
