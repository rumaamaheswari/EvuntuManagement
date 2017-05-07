package com.evuntu.management.model;

import java.sql.Timestamp;

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
@Entity
@Table(name="EVENT_SERVICES")
public class EventServices {

	@Id
	@Column(name="EVENT_SERVICE_ID")
	@GeneratedValue
	private Long id;
	
	@Column(name="COMPANY_ID")
	private Long companyId;
	
	@Column(name="EVENT_NAME")
	private String eventName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="CONTACT_PERSON")
	private String contactPerson;
	
	@Column(name="FACEBOOK_LINK")
	private String faceBookLink;
	
	@Column(name="YOUTUBE_LINK")
	private String youTubeLink;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	
	@Column(name="FILE_ID")
	private Long fileId;
	
	@Column(name="UPDATED_TIME")
	private Timestamp updatedTime;
	
	@Column(name="CREATED_TIME")
	private Timestamp createdTime;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

}
