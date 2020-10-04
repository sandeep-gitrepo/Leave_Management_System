/**
 * 
 */
package com.sandeep.lms.admin.service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.lms.admin.dao.LeaveDao;
import com.sandeep.lms.dto.LeaveDTO;
import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.a.kumar
 *
 */
@Service
public class LeaveServiceImpl implements LeaveService {

	private static final Logger LOGGER = LogManager.getLogger(LeaveServiceImpl.class);
	
	@Autowired
	private LeaveDao leaveDAO;
	
	@Override
	public LeaveDTO addLeave(LeaveDTO leaveDTO) {
		LOGGER.info("LeaveServiceImpl - addLeave() method Started ======");
		LOGGER.debug("LeaveServiceImpl - addLeave() method Started ======");
		
		leaveDAO.addLeave(leaveDTO);

		LOGGER.info("LeaveServiceImpl - addLeave() method Ended ======");
		LOGGER.debug("LeaveServiceImpl - addLeave() method Ended ======");
		
		return leaveDTO;
	}

	@Override
	public List<LeaveDTO> getAllLeaves() {
		LOGGER.info("LeaveServiceImpl - addLeave() method Started ======");
		LOGGER.debug("LeaveServiceImpl - addLeave() method Started ======");
		
		return leaveDAO.getAllLeaves();

	}

	@Override
	public LeaveDTO updateLeave(LeaveDTO leaveDTO) {
		LOGGER.info("LeaveServiceImpl - addLeave() method Started ======");
		LOGGER.debug("LeaveServiceImpl - addLeave() method Started ======");
		
		return leaveDAO.updateLeave(leaveDTO);
		
	}

	@Override
	public void deleteLeave(String leaveCode) {
		LOGGER.info("LeaveServiceImpl - deleteLeave() method Started ======");
		LOGGER.debug("LeaveServiceImpl - deleteLeave() method Started ======");
		
		leaveDAO.deleteLeave(leaveCode);
		
		LOGGER.info("LeaveServiceImpl - deleteLeave() method Ended ======");
		LOGGER.debug("LeaveServiceImpl - deleteLeave() method Ended ======");
	}

	@Override
	public List<LeaveDetailsDTO> getAllLeavesByEmpId(Integer emp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLeaveDetails(List<LeaveDetailsDTO> ls) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LeaveDetailsDTO applyLeave(LeaveDetailsDTO leaveDTO) {

		return leaveDAO.applyLeave(leaveDTO);
		
	}
	
}
