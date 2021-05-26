/**
 * 
 */
package com.sandeep.lms.admin.dao;

import java.util.List;

import com.sandeep.lms.dto.EmpAppliedLeaveDTO;
import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
public interface AdminDao {

	List<EmpAppliedLeaveDTO> getLeavesByLeaveStatus(String leave_Status);

	void updateLeaveDetails(EmployeeLeaveDetailsDTO leaveDtlDto);

	EmployeeLeaveDetailsDTO getLeaveDetailsDTOById(Integer id);

}
