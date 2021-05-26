/**
 * 
 */
package com.sandeep.lms.admin.service;

import java.util.List;

import com.sandeep.lms.dto.EmpAppliedLeaveDTO;
import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
public interface AdminService {

	List<EmpAppliedLeaveDTO> getLeavesByLeaveStatus(String leave_status);

	void updateLeaveDetails(EmployeeLeaveDetailsDTO leaveDtlDto);

	EmployeeLeaveDetailsDTO getLeaveDetailsDTOById(Integer id);
	
}
