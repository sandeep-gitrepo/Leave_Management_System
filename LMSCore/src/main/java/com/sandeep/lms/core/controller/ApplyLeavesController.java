/**
 * 
 */
package com.sandeep.lms.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.sandeep.lms.dto.LeaveDTO;
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
	private LeaveService leaveService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeLMSCore(ModelMap model) {
		LOGGER.info("ApplyLeavesController - welcomeLMSCore method called ==========");
		LOGGER.debug("ApplyLeavesController - welcomeLMSCore method called ==========");

		LOGGER.info("ApplyLeavesController - welcomeLMSCore method ended ==========");
		LOGGER.debug("ApplyLeavesController - welcomeLMSCore method endled ==========");

		return "<br />\r\n" + "		<br />\r\n"
				+ "		<h1 align=\"center\">LMS Core Application is running......</h1>";
	}

	@PostMapping(value = "/addleave")
	public LeaveDTO addLeave(@RequestBody LeaveDTO leaveDTO, UriComponentsBuilder consu) {
		LOGGER.info("ApplyLeavesController - addLeave method called ==========");
		LOGGER.debug("ApplyLeavesController - addLeave method called ==========");

		leaveService.addLeave(leaveDTO);

		LOGGER.info("ApplyLeavesController - addLeave method ended ==========");
		LOGGER.debug("ApplyLeavesController - addLeave method endled ==========");

		return leaveDTO;
	}

	@GetMapping(value = "/getallleaves")
	public List<LeaveDTO> getAllLeaves() {
		LOGGER.info("ApplyLeavesController - getAllLeaves method called ==========");
		LOGGER.debug("ApplyLeavesController - getAllLeaves method called ==========");

		return leaveService.getAllLeaves();
	}

	@RequestMapping(value = "/updateleave")
	public LeaveDTO updateLeave(@RequestBody LeaveDTO leaveDTO, UriComponentsBuilder consu) {
		LOGGER.info("ApplyLeavesController - updateLeaves method called ==========");
		LOGGER.debug("ApplyLeavesController - updateLeaves method called ==========");

		return leaveService.updateLeave(leaveDTO);
	}

	@RequestMapping(value = "/deleteleave")
	public void deleteLeave(@RequestBody String leaveCode, UriComponentsBuilder consu) {
		LOGGER.info("ApplyLeavesController - deleteLeave method called ==========");
		LOGGER.debug("ApplyLeavesController - deleteLeave method called ==========");

		leaveService.deleteLeave(leaveCode);
	}

	// Commit One
	// Commit Two
}
