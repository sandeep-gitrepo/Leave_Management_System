/**
 * 
 */
package com.sandeep.lms.applyleaves.service;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
@Service
public class ApplyLeaveServiceImpl implements ApplyLeaveService {

	private static final Logger LOGGER = LogManager.getLogger(ApplyLeaveServiceImpl.class);
	
	/**
	 * 
	 */
	public ApplyLeaveServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<LeaveDetailsDTO> getLeaveBalanceByEmpID(Integer emp_id) {
		LOGGER.info("ApplyLeavesRestClient: getLeaveBalance() method called ==========");

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<LeaveDetailsDTO[]> response = restTemplate.getForEntity("http://localhost:8102/test/leaves/getallleaves/{emp_id}", LeaveDetailsDTO[].class);
		LeaveDetailsDTO[] list = response.getBody();
		
		return Arrays.asList(list);
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
