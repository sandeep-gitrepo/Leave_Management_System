/**
 * 
 */
package com.sandeep.lms.applyleaves.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.lms.applyleaves.client.ApplyLeavesRestClient;
import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
@Service
public class ApplyLeaveServiceImpl implements ApplyLeaveService {

	@Autowired
	private ApplyLeavesRestClient applyLeavesRestClient;
	
	private static final Logger LOGGER = LogManager.getLogger(ApplyLeaveServiceImpl.class);

	/**
	 * 
	 */
	public ApplyLeaveServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<LeaveDetailsDTO> getLeaveBalanceByEmpID(Integer emp_id) {
		LOGGER.info("ApplyLeavesRestClient: getLeaveBalance() method called ==========");

		return applyLeavesRestClient.getLeaveBalanceByEmpID(emp_id);
	}

	public void applyLeave(LeaveDetailsDTO leaveDetails) {
		LOGGER.info("ApplyLeavesRestClient: applyLeave() method called ==========");

		applyLeavesRestClient.applyLeave(leaveDetails);
	}

	public void cancelLeave(LeaveDetailsDTO leaveDetails) {
		LOGGER.info("ApplyLeavesRestClient: cancelLeave() method called ==========");

		applyLeavesRestClient.cancelLeave(leaveDetails);
		
	}

	public void updateLeave(LeaveDetailsDTO leaveDetails) {
		LOGGER.info("ApplyLeavesRestClient: updateLeave() method called ==========");

		applyLeavesRestClient.updateLeave(leaveDetails);
		
	}

}
