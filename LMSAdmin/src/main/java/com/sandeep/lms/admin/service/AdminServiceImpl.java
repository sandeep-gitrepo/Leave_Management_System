/**
 * 
 */
package com.sandeep.lms.admin.service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.lms.admin.dao.AdminDao;
import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	private static final Logger LOGGER = LogManager.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminDao adminDAO;

	@Override
	public List<LeaveDetailsDTO> getAllPendingLeaves() {
		return adminDAO.getAllPendingLeaves();
	}

	@Override
	public List<LeaveDetailsDTO> getAllApprovedLeaves() {
		return adminDAO.getAllApprovedLeaves();
	}

	@Override
	public List<LeaveDetailsDTO> getAllRejectedLeaves() {
		return adminDAO.getAllRejectedLeaves();
	}

	@Override
	public void updateLeaveDetails(LeaveDetailsDTO leaveDtlDto) {
		adminDAO.updateLeaveDetails(leaveDtlDto);
		
	}
	
	
}
