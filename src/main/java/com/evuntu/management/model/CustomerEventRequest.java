package com.evuntu.management.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name="BUDGET")
	private Long budget;
	
	@Column(name="EXPECTATIONS")
	private String expectations;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="USER_ID",nullable=false)
	private User user;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "EVENT_ID",nullable=false)
	private EventMaster event;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="FACILITY_ID",nullable=false) 
	private Facility facility;

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

	/**
	 * @return the event
	 */
	public EventMaster getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(EventMaster event) {
		this.event = event;
	}

	/**
	 * @return the facility
	 */
	public Facility getFacility() {
		return facility;
	}

	/**
	 * @param facility the facility to set
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	

}
