package com.sandeep.lms.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sandeep.lms.admin.constant.LMSAdminConstant;
import com.sandeep.lms.admin.service.AdminService;
import com.sandeep.lms.dto.LeaveDetailsDTO;

@Controller
@SessionAttributes("name")
public class LMSAdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {

		return "adminPage";
	}

	@RequestMapping(value = "/getAllPendingLeaves", method = RequestMethod.GET)
	public String getAllPendingLeaves(Model model) {
		
		List<LeaveDetailsDTO> pendingLeaveList = adminService.getLeavesByLeaveStatus(LMSAdminConstant.LMS_LEAVE_STATUS_PENDING);
		model.addAttribute("pendingLeaveList", pendingLeaveList);

		return "pendingLeaves";
	}

	@RequestMapping(value = "/getAllApprovedLeaves", method = RequestMethod.GET)
	public String getAllApprovedLeaves(Model model) {
		
		List<LeaveDetailsDTO> approvedLeaveList = adminService.getLeavesByLeaveStatus(LMSAdminConstant.LMS_LEAVE_STATUS_APPROVED);
		model.addAttribute("approvedLeaveList", approvedLeaveList);
		
		return "approvedLeaves";
	}

	@RequestMapping(value = "/getAllRejectedLeaves", method = RequestMethod.GET)
	public String getAllRejectedLeaves(Model model) {

		List<LeaveDetailsDTO> rejectedLeaveList = adminService.getLeavesByLeaveStatus(LMSAdminConstant.LMS_LEAVE_STATUS_REJECTED);
		model.addAttribute("rejectedLeaveList", rejectedLeaveList);
		
		return "rejectedLeaves";
	}

	@RequestMapping(value = "/approveLeaves/{id}", method = RequestMethod.GET)
	public String approveLeaves(Model model, @PathVariable("id") Integer id) {

		LeaveDetailsDTO leaveDtlDTO = adminService.getLeaveDetailsDTOById(id);

		// Updating LeaveDetailsDTO with status 'Approved'
		leaveDtlDTO.setStatus("Approved");
		
		int leave_taken = Integer.valueOf(leaveDtlDTO.getLeave_taken()) + Integer.valueOf(leaveDtlDTO.getTotalNoOfDays());
		leaveDtlDTO.setLeave_taken(String.valueOf(leave_taken));
		
		int leave_balance = Integer.valueOf(leaveDtlDTO.getTotal_leaves()) - Integer.valueOf(leaveDtlDTO.getLeave_taken());
		leaveDtlDTO.setCurrent_balance(String.valueOf(leave_balance));
		
		adminService.updateLeaveDetails(leaveDtlDTO);

		model.addAttribute("leaveDtlDTO", leaveDtlDTO);

		return "successApprovedLeaves";
	}

	@RequestMapping(value = "/rejectLeaves/{id}", method = RequestMethod.GET)
	public String rejectLeaves(Model model, @PathVariable("id") Integer id) {

		LeaveDetailsDTO leaveDtlDTO = adminService.getLeaveDetailsDTOById(id);

		// Updating LeaveDetailsDTO with status 'Rejected'
		leaveDtlDTO.setStatus("Rejected");
		adminService.updateLeaveDetails(leaveDtlDTO);

		model.addAttribute("leaveDtlDTO", leaveDtlDTO);

		return "successRejectedLeaves";
	}

}
