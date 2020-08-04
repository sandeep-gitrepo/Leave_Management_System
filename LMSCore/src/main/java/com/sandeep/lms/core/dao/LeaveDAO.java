/**
 * 
 */
package com.sandeep.lms.core.dao;

import java.util.List;

import com.sandeep.lms.dto.LeaveDTO;
import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
public interface LeaveDAO {

	LeaveDTO addLeave(LeaveDTO leaveDTO);

	List<LeaveDTO> getAllLeaves();

	LeaveDTO updateLeave(LeaveDTO leaveDTO);

	void deleteLeave(String leaveCode);

	List<LeaveDetailsDTO> getAllLeavesByEmpId(Integer emp_id);

	void updateLeaveDetails(List<LeaveDetailsDTO> ls);
	
}
