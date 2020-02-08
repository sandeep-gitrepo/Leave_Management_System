/**
 * 
 */
package com.sandeep.lms.core.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author sandeep.a.kumar
 *
 */
@SpringBootApplication(scanBasePackages = {"com.sandeep.lms.core"})
public class Application {

	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}

}

//http://localhost:8102/test/leaves/addleave