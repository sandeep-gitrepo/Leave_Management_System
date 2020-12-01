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

	List<LeaveDetailsDTO> getLeavesByLeaveStatus(String leave_status);

	void updateLeaveDetails(LeaveDetailsDTO leaveDtlDto);

	LeaveDetailsDTO getLeaveDetailsDTOById(Integer id);
	
}
