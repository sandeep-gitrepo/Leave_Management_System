/**
 * 
 */
package com.sandeep.lms.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sandeep.a.kumar
 *
 */
@SpringBootApplication(scanBasePackages = {"com.sandeep.lms", "com.sandeep.lms.admin"})
public class LMSAdminMainApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LMSAdminMainApplication.class, args);
	}

}

//     http://localhost:8102/test/leaves/getallleaves

//		http://localhost:8102/test/