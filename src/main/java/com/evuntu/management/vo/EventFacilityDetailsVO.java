package com.evuntu.management.vo;

/**
 * Entity bean
 * @author umaa maheswari
 *
 */
public class EventFacilityDetailsVO {


	private Long eventFacilityId;	
 
	private Long  eventId;
	
	private String  eventName;   

	private Long  facilityId;
	
	private String  facilityName;
	
	private String  facilityCity;

	
	public EventFacilityDetailsVO(Long eventFacilityId, Long  eventId,String  eventName, Long  facilityId, String  facilityName, String  facilityCity) {
		this.eventFacilityId=eventFacilityId;
		this.eventId=eventId;
		this.eventName=eventName;
		this.facilityId=facilityId;
		this.facilityName=facilityName;
		this.facilityCity=facilityCity;
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
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}


	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
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
	 * @return the facililityName
	 */
	public String getFacilityName() {
		return facilityName;
	}


	/**
	 * @param facililityName the facililityName to set
	 */
	public void setFacilityName(String facililityName) {
		this.facilityName = facililityName;
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
	
	
}
