/**
 * 
 */
package com.eai.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eai.integration.bo.ClaimDetails;

/**
 * @author AMEER
 *
 */
@Repository
public interface ClaimsRepository extends JpaRepository<ClaimDetails, Long>{
	/*
	 * ClaimDetails findById(Integer claimNumber); void deleteById(Integer
	 * claimNumber);
	 */
}
