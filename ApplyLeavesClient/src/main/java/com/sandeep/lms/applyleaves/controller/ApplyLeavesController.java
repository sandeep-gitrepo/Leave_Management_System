/**
 * 
 */
package com.sandeep.lms.applyleaves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sandeep.lms.applyleaves.service.ApplyLeaveService;
import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
@Controller
public class ApplyLeavesController {

	@Autowired
	private ApplyLeaveService applyLeaveService;

	@RequestMapping(value = "/")
	public String applyLeave(Model m) {

		
		
		m.addAttribute("command", new EmployeeLeaveDetailsDTO());

		return "applyLeave";
	}

	@RequestMapping(value = "/submitApplyLeave", method = RequestMethod.POST)
	public String submit(Model m) {

		EmployeeLeaveDetailsDTO leav = new EmployeeLeaveDetailsDTO();

		leav.set_id(2);
		leav.setEmp_id(2);
		leav.setLeave_id(3);

		applyLeaveService.applyLeave(leav);

		return "applyLeave";
	}
}
