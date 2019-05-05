/**
 * 
 */
package com.eai.integration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eai.integration.bo.ClaimDetails;
import com.eai.integration.bo.ClaimsResponse;
import com.eai.integration.repository.ClaimsRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * @author AMEER
 *
 */

@RestController
@RequestMapping("/api/v1")
@Api(value="Claims API", 
description="Claims API Resources")
public class ClaimsController {
	
	@Autowired
	private ClaimsRepository claimsRepository;
	
	private final static Logger LOG = Logger.getLogger(ClaimsController.class.toString());

	@GetMapping("/hello")
    public String hello() {
            return "Hello Spring Boot!";
    }

	@ApiOperation(value = "Create Claim", response = ClaimsResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(value = "/claims", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaimsResponse> createClaim(@RequestBody ClaimDetails claimDetails) {
		LOG.info("Request for Create Claim  >>>>> "+claimDetails);
		ClaimsResponse claimsResponse = new ClaimsResponse();
		Random r = new Random( System.currentTimeMillis() );
		Integer claimNumber = 10000 + r.nextInt(20000);
		claimDetails.setClaimNumber(claimNumber);
		System.out.println(claimsRepository.save(claimDetails));
		claimsResponse.setStatus("SUCCESS");
		claimsResponse.setMessage("Clain has been created successfully");
		claimsResponse.setClaimNumber(claimNumber.toString());
		LOG.info("Response from Create Claim  >>>>> "+claimsResponse);
		return new ResponseEntity<ClaimsResponse>(claimsResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retrieve All Claims", response = ClaimsResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(value = "/claims", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClaimDetails>> retrieveAllClaims() {
		List<ClaimDetails> claims = new ArrayList<ClaimDetails>();
		claims = claimsRepository.findAll();
		return new ResponseEntity<List<ClaimDetails>>(claims, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete All Claims", response = ClaimsResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 204, message = "Successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(value = "/claims", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaimsResponse> deleteAllClaims() {
		ClaimsResponse claimsResponse = new ClaimsResponse();
		claimsRepository.deleteAll();
		claimsResponse.setStatus("SUCCESS");
		claimsResponse.setMessage("Deleted All claims");
		return new ResponseEntity<ClaimsResponse>(claimsResponse, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Update a Claim", response = ClaimsResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(value = "/claims/{claimNumber}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaimsResponse> updateClaim(@RequestBody ClaimDetails claimDetails,  @PathVariable Long claimNumber) {
		//ClaimDetails claim = claimsRepository.findById(claimNumber);
		ClaimsResponse claimsResponse = new ClaimsResponse();		
		claimsRepository.save(claimDetails);
		claimsResponse.setStatus("SUCCESS");
		claimsResponse.setMessage("Clain has been created successfully");
		claimsResponse.setClaimNumber(claimNumber.toString());
		return new ResponseEntity<ClaimsResponse>(claimsResponse, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Retrieve a Claim", response = ClaimsResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(value = "/claims/{claimNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<ClaimDetails>> retrieveClaim(@PathVariable Long claimNumber) {
		Optional<ClaimDetails> claimDetails = claimsRepository.findById(claimNumber);
		return new ResponseEntity<Optional<ClaimDetails>>(claimDetails, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete Claim", response = ClaimsResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(value = "/claims/{claimNumber}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaimsResponse> deleteClaimDetails(@PathVariable Long claimNumber) {
		ClaimsResponse claimsResponse = new ClaimsResponse();	
		claimsRepository.deleteById(claimNumber);
		claimsResponse.setStatus("SUCCESS");
		claimsResponse.setMessage("Clain has been created successfully");
		claimsResponse.setClaimNumber(claimNumber.toString());
		return new ResponseEntity<ClaimsResponse>(claimsResponse, HttpStatus.OK);
	}
	
}
