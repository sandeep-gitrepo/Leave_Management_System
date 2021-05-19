/**
 * 
 */
package com.sandeep.lms.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sandeep.a.kumar
 *
 */
@Document(collection = "emp_leaves_details")
public class LeaveDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer _id;
	private Integer emp_id;
	private String emp_name;
	private Integer leave_id;
	private String leave_type_name;
	private String opening_balance;
	private String current_balance;
	private String leave_taken;
	private Integer applied_leaves;
	private String start_date;
	private String end_date;
	private String totalNoOfDays;
	private String total_leaves; 
	private String status;
	
	/**
	 * 
	 */
	public LeaveDetailsDTO() {
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

	public Integer getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}

	public String getLeave_type_name() {
		return leave_type_name;
	}

	public void setLeave_type_name(String leave_type_name) {
		this.leave_type_name = leave_type_name;
	}

	public String getOpening_balance() {
		return opening_balance;
	}

	public void setOpening_balance(String opening_balance) {
		this.opening_balance = opening_balance;
	}

	public String getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(String current_balance) {
		this.current_balance = current_balance;
	}

	public String getLeave_taken() {
		return leave_taken;
	}

	public void setLeave_taken(String leave_taken) {
		this.leave_taken = leave_taken;
	}

	public Integer getApplied_leaves() {
		return applied_leaves;
	}

	public void setApplied_leaves(Integer applied_leaves) {
		this.applied_leaves = applied_leaves;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getTotalNoOfDays() {
		return totalNoOfDays;
	}

	public void setTotalNoOfDays(String totalNoOfDays) {
		this.totalNoOfDays = totalNoOfDays;
	}

	public String getTotal_leaves() {
		return total_leaves;
	}

	public void setTotal_leaves(String total_leaves) {
		this.total_leaves = total_leaves;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
