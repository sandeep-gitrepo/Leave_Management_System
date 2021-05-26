/**
 * 
 */
package com.sandeep.lms.applyleaves.client;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
//Test data
/*
 * This class is responsible for REST Call to LMS Admin Application.
 * 
 */
@Component
public class ApplyLeavesRestClient {

	Logger LOGGER = LogManager.getLogger(ApplyLeavesRestClient.class);

	static final String MAIN_RESOURCE_URI = "http://localhost:8102/test/leaves/";

	public List<EmployeeLeaveDetailsDTO> getLeaveBalanceByEmpID(Integer emp_id) {
		LOGGER.info("ApplyLeavesRestClient: getLeaveBalance() method called ==========");

		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<EmployeeLeaveDetailsDTO[]> response = restTemplate
				.getForEntity(MAIN_RESOURCE_URI + "/getallleaves/{emp_id}", EmployeeLeaveDetailsDTO[].class);
		
		EmployeeLeaveDetailsDTO[] list = response.getBody();

		return Arrays.asList(list);
	}

	public void applyLeave(EmployeeLeaveDetailsDTO leaveDetails) {
		LOGGER.info("ApplyLeavesRestClient: applyLeave() method called ==========");

		// REST-CALL
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(MAIN_RESOURCE_URI + "/applyLeave", leaveDetails, EmployeeLeaveDetailsDTO.class);

	}

	public void cancelLeave(EmployeeLeaveDetailsDTO leaveDetails) {
		LOGGER.info("ApplyLeavesRestClient: cancelLeave() method called ==========");

		// REST-CALL
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(MAIN_RESOURCE_URI + "/deleteleave", leaveDetails, EmployeeLeaveDetailsDTO.class);
	}

	public void updateLeave(EmployeeLeaveDetailsDTO leaveDetails) {
		LOGGER.info("ApplyLeavesRestClient: updateLeave() method called ==========");

		// REST-CALL
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(MAIN_RESOURCE_URI + "/updateleave", leaveDetails, EmployeeLeaveDetailsDTO.class);

	}

}