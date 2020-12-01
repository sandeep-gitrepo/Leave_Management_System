/**
 * 
 */
package com.sandeep.lms.admin.dao;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.sandeep.lms.admin.mongo.factory.MongoFactory;
import com.sandeep.lms.dto.LeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Logger LOGGER = LogManager.getLogger(AdminDaoImpl.class);

	@Override
	public List<LeaveDetailsDTO> getLeavesByLeaveStatus(String leave_status) {

		DBObject query = BasicDBObjectBuilder.start().add("status", leave_status).get();

		DBCollection collection = MongoFactory.getDBCollection("emp_leaves_details");
		DBCursor dbCursor = collection.find(query);

		List<LeaveDetailsDTO> leaveDtlList = new ArrayList<LeaveDetailsDTO>(dbCursor.size());

		while (dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();

			LeaveDetailsDTO DTO = prepareLeaveDetailsDTO(obj);

			leaveDtlList.add(DTO);
		}

		return leaveDtlList;
	}

	private LeaveDetailsDTO prepareLeaveDetailsDTO(DBObject obj) {
		
		LeaveDetailsDTO DTO = new LeaveDetailsDTO();
		
		double id = Double.valueOf(obj.get("_id").toString());
		DTO.set_id((int) id);

		double num = Double.valueOf(obj.get("emp_id").toString());
		DTO.setEmp_id((int) num);

		double leaveId = Double.valueOf(obj.get("leave_id").toString());
		DTO.setLeave_id((int) leaveId);

		setEmployeeName(DTO);

		setLeaveTypeName(DTO);

		DTO.setTotal_leaves(getBalance(String.valueOf(obj.get("total_leaves"))));
		DTO.setLeave_taken(getBalance(String.valueOf(obj.get("leave_taken"))));
		DTO.setCurrent_balance(getBalance(String.valueOf(obj.get("leave_balance"))));
		
		DTO.setStart_date(getFormattedDate(String.valueOf(obj.get("leave_start_date"))));
		DTO.setEnd_date(getFormattedDate(String.valueOf(obj.get("leave_end_date"))));

		DTO.setTotalNoOfDays(getBalance(String.valueOf(obj.get("total_days"))));
		
		return DTO;
	}

	private String getFormattedDate(String date) {
		final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
		final ZonedDateTime parsed = ZonedDateTime.parse(date, inputFormat);
		final DateTimeFormatter outputFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return outputFormat1.format(parsed);
	}

	private String getBalance(String valueOf) {
		if (valueOf == null || valueOf.equals("null")) {
			return "0.0";
		}
		return valueOf;
	}

	private void setEmployeeName(LeaveDetailsDTO leaveDetailsDTO) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", leaveDetailsDTO.getEmp_id()).get();

		DBCollection collection = MongoFactory.getDBCollection("employee");
		DBCursor dbCursor = collection.find(query);

		while (dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();
			leaveDetailsDTO.setEmp_name(String.valueOf(obj.get("emp_name")));
		}

	}

	private void setLeaveTypeName(LeaveDetailsDTO leaveDetailsDTO) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", leaveDetailsDTO.getLeave_id()).get();

		DBCollection collection = MongoFactory.getDBCollection("leave");
		DBCursor dbCursor = collection.find(query);

		while (dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();
			leaveDetailsDTO.setLeave_type_name(String.valueOf(obj.get("leave")));
			leaveDetailsDTO.setTotal_leaves(String.valueOf(obj.get("leave_days")));
		}

	}

	@Override
	public void updateLeaveDetails(LeaveDetailsDTO leaveDtlDto) {
		
		DBCollection collection = MongoFactory.getDBCollection("emp_leaves_details");

		BasicDBObject existing = (BasicDBObject) collection.findOne(leaveDtlDto.get_id());

		BasicDBObject obj = new BasicDBObject();
		
		obj.put("_id", leaveDtlDto.get_id());
		obj.put("emp_id", leaveDtlDto.getEmp_id());
		obj.put("leave_id", leaveDtlDto.getLeave_id());
		obj.put("total_leaves", leaveDtlDto.getTotal_leaves());
		obj.put("leave_taken", leaveDtlDto.getLeave_taken());
		obj.put("leave_balance", leaveDtlDto.getCurrent_balance());
		obj.put("leave_start_date", String.valueOf(existing.get("leave_start_date")));
		obj.put("leave_end_date", String.valueOf(existing.get("leave_end_date")));
		obj.put("total_days", leaveDtlDto.getTotalNoOfDays());
		obj.put("status", leaveDtlDto.getStatus());

		collection.update(existing, obj);
	}

	@Override
	public LeaveDetailsDTO getLeaveDetailsDTOById(Integer id) {

		DBObject query = BasicDBObjectBuilder.start().add("_id", id).get();

		DBCollection collection = MongoFactory.getDBCollection("emp_leaves_details");
		DBCursor dbCursor = collection.find(query);

		while (dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();

			LeaveDetailsDTO DTO = prepareLeaveDetailsDTO(obj);

			return DTO;
		}
		return null;
	}

}
