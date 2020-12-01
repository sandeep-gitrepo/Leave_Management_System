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

	List<LeaveDetailsDTO> getLeavesByLeaveStatus(String leave_Status);

	void updateLeaveDetails(LeaveDetailsDTO leaveDtlDto);

	LeaveDetailsDTO getLeaveDetailsDTOById(Integer id);

}
