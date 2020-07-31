/**
 * 
 */
package com.sandeep.lms.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author sandeep.a.kumar
 *
 */
@Document(collection = "leave")
public class LeaveDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Field(value = "_id")
	private Integer leaveId;

	@Field(value = "leave_code")
	private String leaveCode;

	@Field(value = "leave")
	private String leave;

	@Field(value = "leave_days")
	private Integer leave_days;

	public LeaveDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveCode() {
		return leaveCode;
	}

	public void setLeaveCode(String leaveCode) {
		this.leaveCode = leaveCode;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public Integer getLeave_days() {
		return leave_days;
	}

	public void setLeave_days(Integer leave_days) {
		this.leave_days = leave_days;
	}

}
