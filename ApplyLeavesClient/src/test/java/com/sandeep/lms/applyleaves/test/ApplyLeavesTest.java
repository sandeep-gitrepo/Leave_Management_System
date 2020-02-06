/**
 * 
 */
package com.sandeep.lms.applyleaves.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sandeep.lms.applyleaves.dto.LeaveDetailsDTO;
import com.sandeep.lms.applyleaves.service.ApplyLeaveService;

/**
 * @author sandeep.a.kumar
 *
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class ApplyLeavesTest {

	@Autowired
	ApplyLeaveService applyLeaveService;
	
	@Test
	public void getLeaveBalanceByEmpID() {
		System.out.println(applyLeaveService != null ? "obj is not null" : "obj is null" );
		
		List<LeaveDetailsDTO> list = applyLeaveService.getLeaveBalanceByEmpID(1);
		
		System.out.println(list != null ? "List is not null" : "List is null" );
	}
	
}
