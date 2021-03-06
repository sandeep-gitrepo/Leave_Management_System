/**
 * 
 */
package com.sandeep.lms.core.service;

import java.util.List;

import com.sandeep.lms.dto.LeaveDTO;
import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
public interface LeaveService {

	LeaveDTO addLeave(LeaveDTO leaveDTO);

	List<LeaveDTO> getAllLeaves();

	LeaveDTO updateLeave(LeaveDTO leaveDTO);

	void deleteLeave(String leaveCode);

	List<EmployeeLeaveDetailsDTO> getAllLeavesByEmpId(Integer emp_id);
	
	void updateLeaveDetails(List<EmployeeLeaveDetailsDTO> ls);

	EmployeeLeaveDetailsDTO applyLeave(EmployeeLeaveDetailsDTO leaveDTO);
	
}
