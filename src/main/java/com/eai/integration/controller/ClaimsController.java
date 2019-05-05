/**
 * 
 */
package com.eai.integration.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eai.integration.repository.ClaimsRepository;


/**
 * @author AMEER
 *
 */

@RestController
public class ClaimsController {

	private final static Logger LOG = Logger.getLogger(ClaimsController.class.toString());
	
	@Autowired
	private ClaimsRepository claimsRepository;

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!";
	}

}
