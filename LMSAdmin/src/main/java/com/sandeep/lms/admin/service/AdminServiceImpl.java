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
import com.sandeep.lms.dto.EmpAppliedLeaveDTO;
import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

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
	public List<EmpAppliedLeaveDTO> getLeavesByLeaveStatus(String leave_Status) {
		return adminDAO.getLeavesByLeaveStatus(leave_Status);
	}

	@Override
	public void updateLeaveDetails(EmployeeLeaveDetailsDTO leaveDtlDto) {
		adminDAO.updateLeaveDetails(leaveDtlDto);
		
	}

	@Override
	public EmployeeLeaveDetailsDTO getLeaveDetailsDTOById(Integer id) {
		
		return adminDAO.getLeaveDetailsDTOById(id);
	}
	
	
}
