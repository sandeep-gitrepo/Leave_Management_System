/**
 * 
 */
package com.sandeep.lms.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sandeep.kumar
 *
 */
@Document(collection = "employee_leaves")
public class EmployeeLeavesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer _id;
	private Integer emp_id;
	private Integer leave_id;
	private String leave_type_name;
	private String current_balance;
	private String leave_taken;
	private String total_leaves;

	/**
	 * 
	 */
	public EmployeeLeavesDTO() {
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

	public String getTotal_leaves() {
		return total_leaves;
	}

	public void setTotal_leaves(String total_leaves) {
		this.total_leaves = total_leaves;
	}

}
