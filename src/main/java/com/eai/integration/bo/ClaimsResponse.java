package com.eai.integration.bo;

/**
 * @author AMEER
 *
 */
public class ClaimsResponse {
	
	private String status;
	private String message;
	private String claimNumber;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

}
