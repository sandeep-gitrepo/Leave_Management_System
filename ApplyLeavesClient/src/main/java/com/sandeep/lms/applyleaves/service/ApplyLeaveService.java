/**
 * 
 */
package com.sandeep.lms.applyleaves.service;

import java.util.List;

import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
public interface ApplyLeaveService {
	List<LeaveDetailsDTO> getLeaveBalanceByEmpID(Integer emp_id);
}
