package com.evuntu.management.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean
 * @author umaa maheswari
 *
 */

public class FacilityVO {

	private Long facilityId;
	
	private String facilityName;
	

/*	public FacilityVO(Long facilityId, String facilityName) {
		this.facilityId = facilityId;
		this.facilityName = facilityName;
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
	
}
