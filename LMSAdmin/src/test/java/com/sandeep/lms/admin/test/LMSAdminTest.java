package com.sandeep.lms.admin.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sandeep.lms.admin.constant.LMSAdminConstant;
import com.sandeep.lms.admin.service.AdminService;
import com.sandeep.lms.dto.EmpAppliedLeaveDTO;
import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

@Controller
@SessionAttributes("name")
public class LMSAdminTest {
	// test 2121
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		
		return "index";
	}

	@RequestMapping(value = "/getAllPendingLeaves", method = RequestMethod.POST)
	@ResponseBody
	public String getAllPendingLeaves(Model model) {
		List<EmpAppliedLeaveDTO> pendingLeaveList = adminService.getLeavesByLeaveStatus(LMSAdminConstant.LMS_LEAVE_STATUS_PENDING);
		model.addAttribute("pendingLeaveList", pendingLeaveList);

		return "pendingLeaves";
	}

	@RequestMapping(value = "/getAllApprovedLeaves", method = RequestMethod.POST)
	@ResponseBody
	public String getAllApprovedLeaves() {

		return "approvedLeaves";
	}

	@RequestMapping(value = "/getAllRejectedLeaves", method = RequestMethod.POST)
	@ResponseBody
	public String getAllRejectedLeaves() {

		return "rejectedLeaves";
	}

}
