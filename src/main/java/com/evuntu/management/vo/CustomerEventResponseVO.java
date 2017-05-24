package com.evuntu.management.vo;

/**
 * 
 * @author umaa maheswari
 *
 */

public class CustomerEventResponseVO {

	private Long customerEventRequestId;
	
	private Long userId;
	
	private Long eventId;
	
	private Long facilityId;
	
	private Long budget;
	
	private String expectations;
	
	private String eventName;

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

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
	
}
