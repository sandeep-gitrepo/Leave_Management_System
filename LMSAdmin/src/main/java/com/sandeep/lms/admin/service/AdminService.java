/**
 * 
 */
package com.sandeep.lms.admin.service;

import java.util.List;

import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
public interface AdminService {

	List<LeaveDetailsDTO> getAllPendingLeaves();

	List<LeaveDetailsDTO> getAllApprovedLeaves();
	
	List<LeaveDetailsDTO> getAllRejectedLeaves();
	
	void updateLeaveDetails(LeaveDetailsDTO leaveDtlDto);
	
}
