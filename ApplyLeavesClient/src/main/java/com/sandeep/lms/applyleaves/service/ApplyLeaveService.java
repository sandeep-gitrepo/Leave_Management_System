/**
 * 
 */
package com.sandeep.lms.applyleaves.service;

import java.util.List;

import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
public interface ApplyLeaveService {
	
	List<EmployeeLeaveDetailsDTO> getLeaveBalanceByEmpID(Integer emp_id);

	void applyLeave(EmployeeLeaveDetailsDTO leaveDetails);
	
	void cancelLeave(EmployeeLeaveDetailsDTO leaveDetailsDTO);
	
	void updateLeave(EmployeeLeaveDetailsDTO leaveDetailsDTO);
	
}
