package com.evuntu.management.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Entity bean
 * @author umaa maheswari
 *
 */
@Entity
@Table(name="EVENT_SERVICES")
public class EventServices implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EVENT_SERVICE_ID")
	@GeneratedValue
	private Long eventServiceId;

	@Column(name="CITY")
	private String city;

	@Column(name="COMPANY_ID")
	private Long companyId;

	@Column(name="CONTACT_NUMBER")
	private String contactNumber;

	@Column(name="CONTACT_PERSON")
	private String contactPerson;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_TIME")
	private Date createdTime;

	@Column(name="FACEBOOK_LINK")
	private String facebookLink;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_TIME")
	private Date updatedTime;

	@Column(name="YOUTUBE_LINK")
	private String youtubeLink;

	//bi-directional one-to-many association to FileDetail
	@OneToMany(cascade=CascadeType.ALL, mappedBy="eventServices")
	private List<FileDetails> fileDetails;
	
	
	@Column(name="EVENT_FACILITY_ID")
	private String eventFacilityId;




	public Long getEventServiceId() {
		return this.eventServiceId;
	}

	public void setEventServiceId(Long eventServiceId) {
		this.eventServiceId = eventServiceId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	public String getFacebookLink() {
		return this.facebookLink;
	}

	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getYoutubeLink() {
		return this.youtubeLink;
	}

	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	public List<FileDetails> getFileDetails() {
		return this.fileDetails;
	}

	public void setFileDetails(List<FileDetails> fileDetails) {
		this.fileDetails = fileDetails;
	}

	public FileDetails addFileDetail(FileDetails fileDetails) {
		getFileDetails().add(fileDetails);
		fileDetails.setEventServices(this);

		return fileDetails;
	}

	public FileDetails removeFileDetail(FileDetails fileDetails) {
		getFileDetails().remove(fileDetails);
		fileDetails.setEventServices(null);

		return fileDetails;
	}
	

	/**
	 * @return the eventFacilityId
	 */
	public String getEventFacilityId() {
		return eventFacilityId;
	}

	/**
	 * @param eventFacilityId the eventFacilityId to set
	 */
	public void setEventFacilityId(String eventFacilityId) {
		this.eventFacilityId = eventFacilityId;
	}

}
