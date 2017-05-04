package com.evuntu.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long facilityId;
	
	@Column(name="FACILITY_NAME")
	private String facilityName;
	

	public Facility() {
	}

	public Facility(Long facilityId, String facilityName) {
		this.facilityId = facilityId;
		this.facilityName = facilityName;
	}

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
