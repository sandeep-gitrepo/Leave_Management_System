/**
 * 
 */
package com.sandeep.lms.applyleaves.client;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sandeep.lms.dto.LeaveDetailsDTO;
import com.sandeep.lms.applyleaves.service.ApplyLeaveService;

/**
 * @author sandeep.a.kumar
 *
 */
//Test data
/*
 * This class is responsible for REST Call to LMS Core Application. 
 * 
 * */

public class ApplyLeavesRestClient {

	Logger LOGGER = LogManager.getLogger(ApplyLeavesRestClient.class);

	@Autowired
	private ApplyLeaveService applyLeaveService;
	
	public List<LeaveDetailsDTO> getLeaveBalanceByEmpID(Integer emp_id) {
		LOGGER.info("ApplyLeavesRestClient: getLeaveBalance() method called ==========");
		
		return applyLeaveService.getLeaveBalanceByEmpID(emp_id);
	}

	public void applyLeave() {
		LOGGER.info("ApplyLeavesRestClient: applyLeave() method called ==========");
		
	}

	public void cancelLeave() {
		LOGGER.info("ApplyLeavesRestClient: cancelLeave() method called ==========");
		
	}

	public void updateLeave() {
		LOGGER.info("ApplyLeavesRestClient: updateLeave() method called ==========");
		
	}

}