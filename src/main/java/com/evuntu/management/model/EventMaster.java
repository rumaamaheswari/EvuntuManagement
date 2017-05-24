package com.evuntu.management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EVENT_ID")
	private Long eventId;
	
	@Column(name="EVENT_NAME")
	private String eventName;
	
	/*@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "EVENT_FACILITY", joinColumns = { @JoinColumn(name = "EVENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "FACILITY_ID") })	
	private List<Facility> facility=new ArrayList<>(); */
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "event")
	private Set<EventFacility> eventFacility = new HashSet<>();

	
	public EventMaster(){
	
	}
	/*//no default constuctor -parent insert will not work if provided
	public EventMaster(Long eventId, String eventName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		
	}*/
	
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
