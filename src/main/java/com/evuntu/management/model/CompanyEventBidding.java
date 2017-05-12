package com.evuntu.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean
 * @author umaa maheswari
 *
 */
@Entity
@Table(name="COMAPNY_EVENT_BIDDING")
public class CompanyEventBidding {

	@Id
	@Column(name="COMAPNY_EVENT_BIDDING_ID")
	@GeneratedValue
	private Long companyEvenetBiddingId;
	
	@Column(name="COMPANY_ID",nullable=false)
	private Long companyId;
	
	@Column(name="CUSTOMER_EVENT_REQUEST_ID",nullable=false)
	private Long customerEventRequestId;
	
	@Column(name="BIDDING_AMT",nullable=false) 
	private Long biddingAmt;
	
	@Column(name="HASWON")
	private Long hasWon;
	
	@Column(name="CUSTOMER_FEEDBACK")
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
