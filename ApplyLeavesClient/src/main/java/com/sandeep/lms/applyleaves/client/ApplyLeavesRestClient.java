/**
 * 
 */
package com.sandeep.lms.applyleaves.client;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.sandeep.lms.applyleaves.service.ApplyLeaveService;
import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
//Test data
/*
 * This class is responsible for REST Call to LMS Core Application. 
 * 
 * */
@Component
public class ApplyLeavesRestClient {

	Logger LOGGER = LogManager.getLogger(ApplyLeavesRestClient.class);

	static final String MAIN_RESOURCE_URI = "http://localhost:8102/test/leaves/";
	
	@Autowired
	private ApplyLeaveService applyLeaveService;
	
	public List<LeaveDetailsDTO> getLeaveBalanceByEmpID(Integer emp_id) {
		LOGGER.info("ApplyLeavesRestClient: getLeaveBalance() method called ==========");
		
		return applyLeaveService.getLeaveBalanceByEmpID(emp_id);
	}

	public @ResponseBody LeaveDetailsDTO applyLeave(LeaveDetailsDTO leaveDetails) {
		LOGGER.info("ApplyLeavesRestClient: applyLeave() method called ==========");
		
		// REST-CALL
		RestTemplate restTemplate = new RestTemplate();
		LeaveDetailsDTO leaveDetailsDTO = restTemplate.postForObject(MAIN_RESOURCE_URI + "/applyLeave", leaveDetails, LeaveDetailsDTO.class);
		
		return leaveDetailsDTO;
	}

	public void cancelLeave() {
		LOGGER.info("ApplyLeavesRestClient: cancelLeave() method called ==========");
		
	}

	public void updateLeave() {
		LOGGER.info("ApplyLeavesRestClient: updateLeave() method called ==========");
		
	}

}