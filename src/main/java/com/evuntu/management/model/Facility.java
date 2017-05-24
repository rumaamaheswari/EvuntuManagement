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
@Table(name="FACILITY")
public class Facility {

	@Id
	@Column(name="FACILITY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long facilityId;
	
	@Column(name="FACILITY_NAME")
	private String facilityName;
	
	@Column(name="FACILITY_CITY")
	private String facilityCity;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "facility")
	 private Set<EventFacility> eventFacility = new HashSet<>();
	
	 public Facility(){
		 
	 }
	/*//no default constuctor -parent insert will not work if provided
	 
	public Facility(Long facilityId, String facilityName,String facilityCity) {
		super();
		this.facilityId = facilityId;
		this.facilityName = facilityName;
		this.facilityCity =facilityCity;
	}*/

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	
	/**
	 * @return the facilityCity
	 */
	public String getFacilityCity() {
		return facilityCity;
	}

	/**
	 * @param facilityCity the facilityCity to set
	 */
	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}

	/**
	 * @return the eventFacility
	 */
	public Set<EventFacility> getEventFacility() {
		return eventFacility;
	}

	/**
	 * @param eventFacility the eventFacility to set
	 */
	public void setEventFacility(Set<EventFacility> eventFacility) {
		this.eventFacility = eventFacility;
	}
	
	public void addEventFacility(EventFacility eventFacility) {
		this.eventFacility.add(eventFacility);
	}
	
}
