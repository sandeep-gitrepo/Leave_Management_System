
/**
 * 
 */
package com.sandeep.lms.ems.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.sandeep.lms.dto.EmployeeDTO;
import com.sandeep.lms.ems.factory.MongoFactory;

/**
 * @author sandeep.a.kumar
 *
 */

@Repository(value = "employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeDAOImpl.class);
	
	public void addEmployee(EmployeeDTO employeeDTO) {
		LOGGER.info("EmployeeDAOImpl: addEmployee() method called ======");
		
		DBCollection collection = MongoFactory.getDBCollection("employee");
		
		BasicDBObject obj = new BasicDBObject();
		/*
		 * DBCursor cursor = collection.find().sort(obj).limit(1);
		 * while(cursor.hasNext()) { DBObject obj1 = cursor.next(); empId =
		 * Integer.valueOf(obj1.get("_id").toString()); }
		 */
		
		List<EmployeeDTO> list = getAllEmployees();
		
		obj.put("_id", list.get(list.size()-1).getEmpId()+1);
		obj.put("emp_name", employeeDTO.getEmpName());
		obj.put("ctc", employeeDTO.getCtc());
		obj.put("designation", employeeDTO.getDesignation());
		obj.put("department", employeeDTO.getDepartment());
		obj.put("email", employeeDTO.getEmail());
		obj.put("password", employeeDTO.getPassword());
		
		collection.insert(obj);
	}

	public void editEmployee(EmployeeDTO employeeDTO) {
		LOGGER.info("EmployeeDAOImpl: editEmployee() method called ======");
		
		DBCollection collection = MongoFactory.getDBCollection("employee");
		
		BasicDBObject existing = (BasicDBObject) collection.findOne(employeeDTO.getEmpId()); 
		
		BasicDBObject obj = new BasicDBObject();
		obj.put("_id", employeeDTO.getEmpId());
		obj.put("emp_name", employeeDTO.getEmpName());
		obj.put("ctc", employeeDTO.getCtc());
		obj.put("designation", employeeDTO.getDesignation());
		obj.put("department", employeeDTO.getDepartment());
		
		collection.update(existing, obj);
	}

	public EmployeeDTO getEmployeeByID(Integer empId) {
		LOGGER.info("EmployeeDAOImpl: getEmployeeByID() method called ======");
		
		DBCollection collection = MongoFactory.getDBCollection("employee");
		
		DBObject where_query = new BasicDBObject();
        where_query.put("_id", empId);
		DBObject obj = collection.findOne(where_query);
		
		EmployeeDTO empDTO = new EmployeeDTO();
		double num = Double.valueOf(obj.get("_id").toString()); 
		int id = (int)num;
				
		empDTO.setEmpId(id);
		empDTO.setEmpName(obj.get("emp_name").toString());
		empDTO.setCtc(Float.valueOf(obj.get("ctc").toString()));
		empDTO.setDesignation(obj.get("designation").toString());
		empDTO.setDepartment(obj.get("department").toString());
		
		return empDTO;
	}

	public void deleteEmployee(Integer empId) {
		LOGGER.info("EmployeeDAOImpl: deleteEmployee() method called ======");
		
		DBCollection collection = MongoFactory.getDBCollection("employee");
		BasicDBObject empDTO = (BasicDBObject) collection.findOne(empId);
		collection.remove(empDTO);
	}

	public List<EmployeeDTO> getAllEmployees() {
		LOGGER.info("EmployeeDAOImpl: getAllEmployees() method called ======");
		
		DBCollection collection = MongoFactory.getDBCollection("employee");
		DBCursor dbCursor = collection.find();
		
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>(dbCursor.size());
		
		while(dbCursor.hasNext()) {
			DBObject obj = dbCursor.next();
			
			EmployeeDTO empDTO = new EmployeeDTO();
			
			double num = Double.valueOf(obj.get("_id").toString()); 
			int id = (int)num;
					
			empDTO.setEmpId(id);
			empDTO.setEmpName(String.valueOf(obj.get("emp_name")));
			empDTO.setCtc(Float.valueOf(String.valueOf(obj.get("ctc"))));
			empDTO.setDesignation(String.valueOf(obj.get("designation")));
			empDTO.setDepartment(String.valueOf(obj.get("department")));
			empDTO.setEmail(String.valueOf(obj.get("email")));
			
			empList.add(empDTO);
		}
		
		return empList;
	}

}
