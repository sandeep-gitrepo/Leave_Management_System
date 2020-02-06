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

@Document(collection = "employee")
public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer empId;    
	private String empName;    
	private Float ctc;    
	private String designation; 
	private String department; 
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Float getCtc() {
		return ctc;
	}

	public void setCtc(Float ctc) {
		this.ctc = ctc;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
