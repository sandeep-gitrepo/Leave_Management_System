/**
 * 
 */
package com.sandeep.lms.admin.dao;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Logger LOGGER = LogManager.getLogger(AdminDaoImpl.class);

	@Override
	public List<LeaveDetailsDTO> getAllPendingLeaves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetailsDTO> getAllApprovedLeaves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LeaveDetailsDTO> getAllRejectedLeaves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLeaveDetails(LeaveDetailsDTO leaveDtlDto) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
