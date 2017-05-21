package com.evuntu.management.vo;

import java.util.List;

/**
 * Value bean
 * @author umaa maheswari
 *
 */

public class EventServicesResponseVO {


	private Long eventServiceId;
	
	private Long companyId;
	
	private String eventName;
	
	private String city;
	
	private String contactPerson;
	
	private String faceBookLink;
	
	private String youTubeLink;
	
	private String contactNumber;
	
	private  List<FileDetailsVO> fileDetails;

	
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

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	
	public List<FileDetailsVO> getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(List<FileDetailsVO> fileDetails) {
		this.fileDetails = fileDetails;
	}

	
}
