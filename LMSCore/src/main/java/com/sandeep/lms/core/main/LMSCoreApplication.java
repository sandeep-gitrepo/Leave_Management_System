/**
 * 
 */
package com.sandeep.lms.core.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sandeep.a.kumar
 *
 */
@SpringBootApplication(scanBasePackages = {"com.sandeep.lms.core"})
public class LMSCoreApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LMSCoreApplication.class, args);
	}

}

//http://localhost:8102/test/leaves/addleave