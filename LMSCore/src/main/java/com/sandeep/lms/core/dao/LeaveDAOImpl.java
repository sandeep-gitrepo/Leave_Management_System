/**
 * 
 */
package com.sandeep.lms.core.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.sandeep.lms.dto.LeaveDTO;
import com.sandeep.lms.dto.LeaveDetailsDTO;
import com.sandeep.lms.core.exception.LeaveNotFoundException;

/**
 * @author sandeep.a.kumar
 *
 */

@Repository
public class LeaveDAOImpl implements LeaveDAO {

	Logger LOGGER = LogManager.getLogger("LeaveDaoImpl.class");
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<LeaveDTO> getAllLeaves() {
		LOGGER.info("LeaveDaoImpl - getAllLeaves() method Started ======");
		LOGGER.debug("LeaveDaoImpl - getAllLeaves() method Started ======");
		
		List<LeaveDTO> leaves = null;
		try {
			leaves = mongoTemplate.findAll(LeaveDTO.class);
		}
		catch (Exception e) {
			LOGGER.error("Error occured while inserting record - AddLeave." + e);
		}
		
		LOGGER.info("LeaveDaoImpl - getAllLeaves() method Ended ======");
		LOGGER.debug("LeaveDaoImpl - getAllLeaves() method Ended ======");
		
		return leaves;
	}
	
	@Override
	public LeaveDTO addLeave(LeaveDTO leaveDTO) {
		LOGGER.info("LeaveDaoImpl - addLeave() method Started ======");
		LOGGER.debug("LeaveDaoImpl - addLeave() method Started ======");
		
		try {
			mongoTemplate.save(leaveDTO);
			
			LOGGER.info("LeaveDaoImpl - addLeave() : SUCCESSFULLY INSERTED.");
		}
		catch (Exception e) {
			LOGGER.error("Error occured while inserting record - AddLeave." + e);
		}
		
		LOGGER.info("LeaveDaoImpl - addLeave() method Ended ======");
		LOGGER.debug("LeaveDaoImpl - addLeave() method Ended ======");
		
		return leaveDTO;
	}

	@Override
	public LeaveDTO updateLeave(LeaveDTO leaveDTO) {
		LOGGER.info("LeaveDaoImpl - updateLeave() method Started ======");
		LOGGER.debug("LeaveDaoImpl - updateLeave() method Started ======");
		
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(leaveDTO.getLeaveId()));
			
			Update update = new Update();
			update.set("leave_Code", leaveDTO.getLeaveCode());
			update.set("leave", leaveDTO.getLeave());
			update.set("leave_days", leaveDTO.getLeave_days());
			mongoTemplate.updateFirst(query, update, LeaveDTO.class);
			
			LOGGER.info("LeaveDaoImpl - updateLeave() : SUCCESSFULLY UPDATED.");
			
			LeaveDTO leave = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(leaveDTO.getLeaveId())), LeaveDTO.class);
			return leave;
			
			
		}
		catch (Exception e) {
			LOGGER.error("Error occured while updating record - updateLeave." + e);
		}
		
		LOGGER.info("LeaveDaoImpl - updateLeave() method Ended ======");
		LOGGER.debug("LeaveDaoImpl - updateLeave() method Ended ======");
		
		return null;
	}

	@Override
	public void deleteLeave(String leaveCode) {
		LOGGER.info("LeaveDaoImpl - deleteLeave() method Started ======");
		LOGGER.debug("LeaveDaoImpl - deleteLeave() method Started ======");
		
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("leave_code").is(leaveCode));
			
			LeaveDTO leave = mongoTemplate.findOne(query, LeaveDTO.class);
			
			if(leave == null) {
				LOGGER.error("LeaveDTO not found on given leave code, Please pass correct leave code and try again.");
				throw new LeaveNotFoundException();
			}
			
			mongoTemplate.remove(leave);
			
			LOGGER.info("LeaveDaoImpl - deleteLeave() : SUCCESSFULLY DELETED.");
		}
		catch (Exception e) {
			LOGGER.error("Error occured while deleting record - deleteLeave." + e);
		}
		
		LOGGER.info("LeaveDaoImpl - deleteLeave() method Ended ======");
		LOGGER.debug("LeaveDaoImpl - deleteLeave() method Ended ======");
	}

	@Override
	public List<LeaveDetailsDTO> getAllLeavesByEmpId(Integer emp_id) {
		LOGGER.info("LeaveDaoImpl - getAllLeavesByEmpId() method Started ======");
		LOGGER.debug("LeaveDaoImpl - getAllLeavesByEmpId() method Started ======");
		
		List<LeaveDetailsDTO> leaveDtls = null;
		try {
	//		leaveDtls = mongoTemplate.findAl(LeaveDetailsDTO.class);
		}
		catch (Exception e) {
			LOGGER.error("Error occured while featching records." + e);
		}
		
		LOGGER.info("LeaveDaoImpl - getAllLeavesByEmpId() method Ended ======");
		LOGGER.debug("LeaveDaoImpl - getAllLeavesByEmpId() method Ended ======");
		
		return null;
	}

	@Override
	public void updateLeaveDetails(List<LeaveDetailsDTO> ls) {
		// TODO Auto-generated method stub
		
	}


}
