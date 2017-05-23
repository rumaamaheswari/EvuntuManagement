package com.evuntu.management.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity bean
 * @author umaa maheswari
 * @param <EventMasterVO>
 *
 */

public class EventMasterVO implements Comparable<EventMasterVO> {


	private Long eventId;	

	private String eventName;
	
	private List<FacilityVO> facility=new ArrayList<>();
	

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

	public List<FacilityVO> getFacility() {
		return facility;
	}

	public void setFacility(List<FacilityVO> facility) {
		this.facility = facility;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((facility == null) ? 0 : facility.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EventMasterVO))
			return false;
		EventMasterVO other = (EventMasterVO) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (facility == null) {
			if (other.facility != null)
				return false;
		} else if (!facility.equals(other.facility))
			return false;
		return true;
	}

	@Override
	public int compareTo(EventMasterVO obj) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;

	    //this optimization is usually worthwhile, and can
	    //always be added
	    if ( this == obj ) 
	    	return EQUAL;
	    
	    if (this.eventId < obj.eventId)
	    	return BEFORE;
	    if (this.eventId > obj.eventId) 
	    	return AFTER;
	    
	   // assert this.equals(obj) : "compareTo inconsistent with equals.";
	    
	    return EQUAL;
	}
	
	
	
}
