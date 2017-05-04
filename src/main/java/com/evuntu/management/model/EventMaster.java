package com.evuntu.management.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@Column(name="EVENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	
	@Column(name="EVENT_NAME")
	private String eventName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "EVENT_FACILITY", joinColumns = { @JoinColumn(name = "EVENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "FACILITY_ID") })	
	private List<Facility> facility=new ArrayList<Facility>(); 

	

	public EventMaster() {
		
	}

	public EventMaster(Long eventId, String eventName, List<Facility> facility) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.facility = facility;
	}


	public List<Facility> getFacility() {
		return facility;
	}

	public void setFacility(List<Facility> facility) {
		this.facility = facility;
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
}
