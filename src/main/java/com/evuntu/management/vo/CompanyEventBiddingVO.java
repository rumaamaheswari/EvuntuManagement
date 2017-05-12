package com.evuntu.management.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author umaa maheswari
 *
 */
public class CompanyEventBiddingVO {

	private Long companyEvenetBiddingId;
	
	private Long companyId;
	
	private Long customerEventRequestId;
	
	private Long biddingAmt;
	
	private Long hasWon;
	
	private String customerFeedback;

	/**
	 * @return the companyEvenetBiddingId
	 */
	public Long getCompanyEvenetBiddingId() {
		return companyEvenetBiddingId;
	}

	/**
	 * @param companyEvenetBiddingId the companyEvenetBiddingId to set
	 */
	public void setCompanyEvenetBiddingId(Long companyEvenetBiddingId) {
		this.companyEvenetBiddingId = companyEvenetBiddingId;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the customerEventRequestId
	 */
	public Long getCustomerEventRequestId() {
		return customerEventRequestId;
	}

	/**
	 * @param customerEventRequestId the customerEventRequestId to set
	 */
	public void setCustomerEventRequestId(Long customerEventRequestId) {
		this.customerEventRequestId = customerEventRequestId;
	}

	/**
	 * @return the biddingAmt
	 */
	public Long getBiddingAmt() {
		return biddingAmt;
	}

	/**
	 * @param biddingAmt the biddingAmt to set
	 */
	public void setBiddingAmt(Long biddingAmt) {
		this.biddingAmt = biddingAmt;
	}

	/**
	 * @return the hasWon
	 */
	public Long getHasWon() {
		return hasWon;
	}

	/**
	 * @param hasWon the hasWon to set
	 */
	public void setHasWon(Long hasWon) {
		this.hasWon = hasWon;
	}

	/**
	 * @return the customerFeedback
	 */
	public String getCustomerFeedback() {
		return customerFeedback;
	}

	/**
	 * @param customerFeedback the customerFeedback to set
	 */
	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	
}
