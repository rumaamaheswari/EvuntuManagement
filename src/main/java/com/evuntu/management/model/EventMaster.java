package com.evuntu.management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Entity bean
 * @author umaa maheswari
 *
 */
@Entity
@Table(name="EVENT")
public class EventMaster {

	@Id	
	@GeneratedValue
	@Column(name="EVENT_ID")
	private Long eventId;
	
	@Column(name="EVENT_NAME")
	private String eventName;
	
	/*@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "EVENT_FACILITY", joinColumns = { @JoinColumn(name = "EVENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "FACILITY_ID") })	
	private List<Facility> facility=new ArrayList<>(); */
	
	@OneToMany(mappedBy = "event")
	private Set<EventFacility> eventFacility = new HashSet<>();

	//no default constuctor -parent insert will not work if provided
	public EventMaster(Long eventId, String eventName) {
		this.eventId = eventId;
		this.eventName = eventName;
		
	}
	
	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	
	public Set<EventFacility> getEventFacility() {
		return eventFacility;
	}

	public void setEventFacility(Set<EventFacility> eventFacility) {
		this.eventFacility = eventFacility;
	}
	
	public void addEventFacility(EventFacility eventFacility) {
		this.eventFacility.add(eventFacility);
	}	
}
