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
@Document(collection = "emp_leaves_details")
public class LeaveDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer _id;
	private Integer emp_id;
	private Integer leave_id;
	private Integer opening_balance;
	private Integer current_balance;
	private Integer negative_balance;
	private Integer leave_taken;
	
	/**
	 * 
	 */
	public LeaveDetailsDTO() {
		// TODO Auto-generated constructor stub
	}

	public LeaveDetailsDTO(Integer _id, Integer emp_id, Integer leave_id, Integer opening_balance,
			Integer current_balance, Integer negative_balance, Integer leave_taken) {
		super();
		this._id = _id;
		this.emp_id = emp_id;
		this.leave_id = leave_id;
		this.opening_balance = opening_balance;
		this.current_balance = current_balance;
		this.negative_balance = negative_balance;
		this.leave_taken = leave_taken;
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

	public Integer getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}

	public Integer getOpening_balance() {
		return opening_balance;
	}

	public void setOpening_balance(Integer opening_balance) {
		this.opening_balance = opening_balance;
	}

	public Integer getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(Integer current_balance) {
		this.current_balance = current_balance;
	}

	public Integer getNegative_balance() {
		return negative_balance;
	}

	public void setNegative_balance(Integer negative_balance) {
		this.negative_balance = negative_balance;
	}

	public Integer getLeave_taken() {
		return leave_taken;
	}

	public void setLeave_taken(Integer leave_taken) {
		this.leave_taken = leave_taken;
	}

}
