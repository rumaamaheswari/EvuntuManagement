package com.evuntu.management.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * Value bean
 * @author umaa maheswari
 *
 */

public class EventServicesVO {


	private Long eventServiceId;
	
	private Long companyId;
	
	private Long eventId;
	
	private Long facilityId;
	
	private String city;
	
	private String contactPerson;
	
	private String faceBookLink;
	
	private String youTubeLink;
	
	private String contactNumber;
	
	private  List<MultipartFile> inputFile;
	

	public String getFaceBookLink() {
		return faceBookLink;
	}

	public void setFaceBookLink(String faceBookLink) {
		this.faceBookLink = faceBookLink;
	}

	public String getYouTubeLink() {
		return youTubeLink;
	}

	public void setYouTubeLink(String youTubeLink) {
		this.youTubeLink = youTubeLink;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getEventServiceId() {
		return eventServiceId;
	}

	public void setEventServiceId(Long eventServiceId) {
		this.eventServiceId = eventServiceId;
	}

	/**
	 * @return the inputFile
	 */
	public List<MultipartFile> getInputFile() {
		return inputFile;
	}

	/**
	 * @param inputFile the inputFile to set
	 */
	public void setInputFile(List<MultipartFile> inputFile) {
		this.inputFile = inputFile;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	
}
