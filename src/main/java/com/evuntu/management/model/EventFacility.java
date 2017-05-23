package com.evuntu.management.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Entity bean
 * @author umaa maheswari
 *
 */
@Entity
@Table(name="EVENT_FACILITY")
public class EventFacility {

	@Id
	@Column(name="EVENT_FACILITY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventFacilityId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EVENT_ID") 
	private EventMaster event;
   
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FACILITY_ID")
	private Facility facility;

	
	public EventFacility() {
		
	}

	
	/**
	 * @return the eventFacilityId
	 */
	public Long getEventFacilityId() {
		return eventFacilityId;
	}

	/**
	 * @param eventFacilityId the eventFacilityId to set
	 */
	public void setEventFacilityId(Long eventFacilityId) {
		this.eventFacilityId = eventFacilityId;
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

	
	
}
