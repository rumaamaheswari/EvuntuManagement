package com.evuntu.management.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity bean
 * @author umaa maheswari
 *
 */

public class EventMasterVO {


	private Long eventId;	

	private String eventName;
	
	private List<FacilityVO> facility=new ArrayList<>();
	

	/*public EventMasterVO() {
		}

	public EventMasterVO(Long eventId, String eventName, List<FacilityVO> facility) {
		this.eventId = eventId;
		this.eventName = eventName;
		this.facility = facility;
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

	public List<FacilityVO> getFacility() {
		return facility;
	}

	public void setFacility(List<FacilityVO> facility) {
		this.facility = facility;
	}

	
	
	
}
