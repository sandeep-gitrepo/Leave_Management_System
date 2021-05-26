/**
 * 
 */
package com.sandeep.lms.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sandeep.a.kumar
 *
 */
@Document(collection = "emp_applied_leaves")
public class EmpAppliedLeaveDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer _id;
	private Integer emp_id;
	private String emp_name;
	private Integer leave_id;
	private String leave_type;
	private String leave_start_date;
	private String leave_end_date;
	private Integer total_days;
	private String leave_applied_date;
	private String status;
	private String remarks;

	/**
	 * 
	 */
	public EmpAppliedLeaveDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public String getLeave_start_date() {
		return leave_start_date;
	}

	public void setLeave_start_date(String leave_start_date) {
		this.leave_start_date = leave_start_date;
	}

	public String getLeave_end_date() {
		return leave_end_date;
	}

	public void setLeave_end_date(String leave_end_date) {
		this.leave_end_date = leave_end_date;
	}

	public Integer getTotal_days() {
		return total_days;
	}

	public void setTotal_days(Integer total_days) {
		this.total_days = total_days;
	}

	public String getLeave_applied_date() {
		return leave_applied_date;
	}

	public void setLeave_applied_date(String leave_applied_date) {
		this.leave_applied_date = leave_applied_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}

	
}
