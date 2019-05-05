/**
 * 
 */
package com.eai.integration.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author AMEER
 *
 */
@Entity
@Table(name = "CLAIMS")
@EntityListeners(AuditingEntityListener.class)
public class ClaimDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column(name = "CLAIM_NUMBER")
	private Integer claimNumber;
	@Column(name = "CLAIM_TYPE")
	private String claimType;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "POLICY_NUMBER")
	private String policyNumber;
	@Column(name = "CUSTOMER_ID")
	private String customerID;
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	@Column(name = "EMAIL_ID")
	private String emailID;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "BANK_CODE")
	private String bankCode;
	@Column(name = "BANK_NAME")
	private String bankName;
	@Column(name = "BANK_ADDRESS")
	private String bankAddress;
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Integer getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(Integer claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountnumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
