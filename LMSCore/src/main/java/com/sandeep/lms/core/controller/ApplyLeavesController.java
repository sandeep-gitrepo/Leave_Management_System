/**
 * 
 */
package com.sandeep.lms.core.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sandeep.lms.core.dto.LeaveDTO;
import com.sandeep.lms.core.service.LeaveService;

/**
 * @author sandeep.a.kumar
 *
 */

@RestController
@RequestMapping("/leaves")
public class ApplyLeavesController {

	Logger LOGGER = LogManager.getLogger(ApplyLeavesController.class);
	
	@Autowired
	LeaveService leaveService;
	
	 @PostMapping(value="/addleave")
	 public LeaveDTO addLeave(@RequestBody LeaveDTO leaveDTO, UriComponentsBuilder consu){
		 LOGGER.info("ApplyLeavesController - addLeave method called ==========");
		 LOGGER.debug("ApplyLeavesController - addLeave method called ==========");
		 
		 leaveService.addLeave(leaveDTO);
		 
		 LOGGER.info("ApplyLeavesController - addLeave method ended ==========");
		 LOGGER.debug("ApplyLeavesController - addLeave method endled ==========");
		 
		 return leaveDTO;
	 }
	
	 @GetMapping(value="/getallleaves")
	 public List<LeaveDTO> getAllLeaves() {
		 LOGGER.info("ApplyLeavesController - getAllLeaves method called ==========");
		 LOGGER.debug("ApplyLeavesController - getAllLeaves method called ==========");
		 
		 return leaveService.getAllLeaves();
	 }
	
	 @RequestMapping(value="/updateleave")
	 public LeaveDTO updateLeave(@RequestBody LeaveDTO leaveDTO, UriComponentsBuilder consu) {
		 LOGGER.info("ApplyLeavesController - updateLeaves method called ==========");
		 LOGGER.debug("ApplyLeavesController - updateLeaves method called ==========");
		 
		 return leaveService.updateLeave(leaveDTO);
	 }
	 
	 @RequestMapping(value="/deleteleave")
	 public void deleteLeave(@RequestBody String leaveCode, UriComponentsBuilder consu) {
		 LOGGER.info("ApplyLeavesController - deleteLeave method called ==========");
		 LOGGER.debug("ApplyLeavesController - deleteLeave method called ==========");
		 
		 leaveService.deleteLeave(leaveCode);
	 }
	 
}
