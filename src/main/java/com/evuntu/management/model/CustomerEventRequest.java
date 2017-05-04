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
@Table(name="CUSTOMER_EVENT_REQUEST")
public class CustomerEventRequest {

	@Id
	@Column(name="CUSTOMER_EVENT_REQUEST_ID")
	@GeneratedValue
	private Long customerEventRequestId;
	
	@Column(name="USER_ID",nullable=false)
	private Long userId;
	
	@Column(name="EVENT_ID",nullable=false)
	private Long eventId;
	
	@Column(name="FACILITY_ID",nullable=false) 
	private Long facilityId;
	
	@Column(name="BUDGET")
	private Long budget;
	
	@Column(name="EXPECTATIONS")
	private String expectations;

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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the facilityId
	 */
	public Long getFacilityId() {
		return facilityId;
	}

	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	/**
	 * @return the budget
	 */
	public Long getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(Long budget) {
		this.budget = budget;
	}

	/**
	 * @return the expectations
	 */
	public String getExpectations() {
		return expectations;
	}

	/**
	 * @param expectations the expectations to set
	 */
	public void setExpectations(String expectations) {
		this.expectations = expectations;
	}

	
	
}
