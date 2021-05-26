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
import com.sandeep.lms.dto.EmpAppliedLeaveDTO;
import com.sandeep.lms.dto.EmployeeLeaveDetailsDTO;

/**
 * @author sandeep.kumar
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao {

	private static final Logger LOGGER = LogManager.getLogger(AdminDaoImpl.class);

	@Override
	public List<EmpAppliedLeaveDTO> getLeavesByLeaveStatus(String leave_status) {

		DBObject query = BasicDBObjectBuilder.start().add("status", leave_status).get();
		DBCollection collection = MongoFactory.getDBCollection("emp_applied_leaves");
		DBCursor dbCursor = collection.find(query);

		List<EmpAppliedLeaveDTO> empAppliedLeavesList = new ArrayList<EmpAppliedLeaveDTO>(dbCursor.size());

		while (dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();
			EmpAppliedLeaveDTO DTO = prepareEmpAppliedLeaveDTO(obj);
			empAppliedLeavesList.add(DTO);
		}

		return empAppliedLeavesList;
	}

	private EmpAppliedLeaveDTO prepareEmpAppliedLeaveDTO(DBObject obj) {

		EmpAppliedLeaveDTO DTO = new EmpAppliedLeaveDTO();

		double id = Double.valueOf(obj.get("_id").toString());
		DTO.set_id((int) id);

		double num = Double.valueOf(obj.get("emp_id").toString());
		DTO.setEmp_id((int) num);

	//	double leaveId = Double.valueOf(obj.get("leave_id").toString());
	//	DTO.setLeave_id((int) leaveId);

		setEmployeeName(DTO);
		DTO.setLeave_type(String.valueOf(obj.get("leave_type")));
		DTO.setLeave_applied_date(String.valueOf(obj.get("leave_applied_date")));
		DTO.setLeave_start_date(String.valueOf(obj.get("leave_start_date")));
		DTO.setLeave_end_date(String.valueOf(obj.get("leave_end_date")));
		DTO.setStatus(String.valueOf(obj.get("status")));
		DTO.setRemarks(String.valueOf(obj.get("remarks")));
		
	//	double totalDays = Double.valueOf(obj.get("total_days").toString());
//		DTO.setTotal_days((int) totalDays);
		
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

	private void setEmployeeName(EmpAppliedLeaveDTO empAppliedLeaveDTO) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", empAppliedLeaveDTO.getEmp_id()).get();

		DBCollection collection = MongoFactory.getDBCollection("employee");
		DBCursor dbCursor = collection.find(query);

		while (dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();
			empAppliedLeaveDTO.setEmp_name(String.valueOf(obj.get("emp_name")));
		}

	}

	@Override
	public void updateLeaveDetails(EmployeeLeaveDetailsDTO leaveDtlDto) {

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
	public EmployeeLeaveDetailsDTO getLeaveDetailsDTOById(Integer id) {

		DBObject query = BasicDBObjectBuilder.start().add("_id", id).get();

		DBCollection collection = MongoFactory.getDBCollection("emp_leaves_details");
		DBCursor dbCursor = collection.find(query);

		while (dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();

	//		EmployeeLeaveDetailsDTO DTO = prepareLeaveDetailsDTO(obj);

			return null;	// DTO;
		}
		return null;
	}

}
