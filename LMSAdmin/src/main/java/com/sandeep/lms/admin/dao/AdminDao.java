/**
 * 
 */
package com.sandeep.lms.admin.dao;

import java.util.List;

import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
public interface AdminDao {

	List<LeaveDetailsDTO> getAllPendingLeaves();

	List<LeaveDetailsDTO> getAllApprovedLeaves();
	
	List<LeaveDetailsDTO> getAllRejectedLeaves();

	void updateLeaveDetails(LeaveDetailsDTO leaveDtlDto);
	
}
